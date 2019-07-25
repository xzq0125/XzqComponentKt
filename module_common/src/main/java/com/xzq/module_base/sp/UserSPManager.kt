package com.xzq.module_base.sp

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

import com.xzq.module_base.bean.UserBean
import com.xzq.module_base.config.Config
import com.xzq.module_base.utils.Utils
import com.xzq.module_base.utils.cipher.CipherUtils

/**
 * 用户SP数据
 * Created by Wesley on 2018/7/9.
 */

object UserSPManager {

    private const val SP_USER_INFO = "user_info"// 用户数据，退出登录后删除
    private const val KEY_LOGIN_DATA = "login_data"// 登录数据

    /**
     * 获取用户信息 SharedPreferences
     *
     * @return SharedPreferences
     */
    private val userInfoSharedPreferences: SharedPreferences
        get() {
            val context = Utils.getContext()
            return context.getSharedPreferences(SP_USER_INFO, Context.MODE_PRIVATE)
        }

    /**
     * 获取登录数据
     *
     * @return 登录数据
     */
    val loginData: UserBean?
        get() {
            val cipher = userInfoSharedPreferences.getString(KEY_LOGIN_DATA, null)
            return if (TextUtils.isEmpty(cipher)) null else CipherUtils.decryptAES(
                Config.CACHE_PASSWORD, Config.CACHE_SALT,
                cipher, UserBean::class.java
            )
        }

    /**
     * 用户退出登录，清除所有用户数据
     */
    fun clearUserData() {
        userInfoSharedPreferences.edit().clear().apply()
    }

    /**
     * 存储登录数据
     *
     * @param data 登录数据
     */
    fun putLoginData(data: UserBean?) {
        if (data == null) {
            userInfoSharedPreferences.edit().remove(KEY_LOGIN_DATA).apply()
            return
        }
        val cipher = CipherUtils.encryptAES(Config.CACHE_PASSWORD, Config.CACHE_SALT, data) ?: return
        userInfoSharedPreferences.edit().putString(KEY_LOGIN_DATA, cipher).apply()
    }

}
