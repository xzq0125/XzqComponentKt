package com.xzq.module_base

import android.text.TextUtils
import com.xzq.module_base.bean.UserBean
import com.xzq.module_base.sp.UserSPManager
import com.xzq.module_base.utils.StringUtils


/**
 * 登录信息管理
 * Created by Wesley on 2018/7/9.
 */

object User {

    private var sLogin: UserBean? = null

    /**
     * 用户是否已经登录
     *
     * @return 是否已经登录
     */
    val isLogin: Boolean
        get() = sLogin != null

    /**
     * 获取用户登录凭证
     *
     * @return 用户登录凭证
     */
    val token: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.token))
            sLogin!!.token
        else
            ""

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    val id: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.uid))
            sLogin!!.uid
        else
            ""

    /**
     * 获取用户名称（注册后username跟手机号相同）
     *
     * @return 用户名称
     */
    val name: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.username))
            sLogin!!.username
        else
            ""

    /**
     * 获取用户昵称
     *
     * @return 用户昵称
     */
    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    var nickname: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.nickname))
            sLogin!!.nickname
        else
            ""
        set(nickname) {
            val login = sLogin
            if (login != null) {
                login.nickname = nickname
                setLoginData(login)
            }
        }

    /**
     * 获取用户电话
     *
     * @return 用户电话
     */
    /**
     * 设置用户电话
     *
     * @return 用户电话
     */
    var phone: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.cellphone))
            sLogin!!.cellphone
        else
            ""
        set(cellPhone) {
            val login = sLogin
            if (login != null) {
                login.cellphone = cellPhone
                setLoginData(login)
            }
        }

    /**
     * 获取用户性别
     *
     * @return 用户性别
     */
    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    var sex: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.sex))
            sLogin!!.sex
        else
            ""
        set(sex) {
            val login = sLogin
            if (login != null) {
                login.sex = sex
                setLoginData(login)
            }
        }

    /**
     * 获取用户头像
     *
     * @return 用户头像
     */
    /**
     * 设置用户头像
     *
     * @param header 用户头像
     */
    var portrait: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.header))
            sLogin!!.header
        else
            ""
        set(header) {
            val login = sLogin
            if (login != null) {
                login.header = header
                setLoginData(login)
            }
        }

    /**
     * 获取用户区域ID
     *
     * @return 用户区域ID
     */
    /**
     * 设置用户区域ID
     *
     * @param aid 用户区域ID
     */
    var aId: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.aid))
            sLogin!!.aid
        else
            ""
        set(aid) {
            val login = sLogin
            if (login != null) {
                login.aid = aid
                setLoginData(login)
            }
        }

    /**
     * 获取页面显示的昵称
     * 如果nickname为空，则用username（注册后username跟手机号相同）
     *
     * @return 页面显示的昵称
     */
    val showNickname: String?
        get() {
            val nickname = nickname
            return if (!TextUtils.isEmpty(nickname)) nickname else name
        }

    /**
     * 获取账户余额
     *
     * @return 账户余额
     */
    /**
     * 设置账户余额
     *
     * @param money 账户余额
     */
    var money: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.money))
            sLogin!!.money
        else
            ""
        set(money) {
            val login = sLogin
            if (login != null) {
                login.money = money
                setLoginData(login)
            }
        }

    /**
     * 获取个性签名
     */
    /**
     * 设置个性签名
     */
    var sign: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.sign))
            sLogin!!.sign
        else
            ""
        set(sign) {
            val login = sLogin
            if (login != null) {
                login.sign = sign
                setLoginData(login)
            }
        }

    /**
     * 获取用户积分
     */
    /**
     * 设置用户积分
     *
     * @return 用户积分
     */
    var integral: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.integral))
            sLogin!!.integral
        else
            "0"
        set(integral) {
            val login = sLogin
            if (login != null) {
                login.integral = integral
                setLoginData(login)
            }
        }

    /**
     * 获取用户未读推送消息
     */
    /**
     * 设置用户未读推送消息
     *
     * @param unreadMessage 用户未读推送消息
     */
    var unreadMessage: String?
        get() = if (sLogin != null && StringUtils.toInt(sLogin!!.unreadMessage) > 0)
            sLogin!!.unreadMessage
        else
            null
        set(unreadMessage) {
            val login = sLogin
            if (login != null) {
                login.unreadMessage = unreadMessage
                setLoginData(login)
            }
        }


    /**
     * 获取用户类型
     */
    /**
     * 设置用户类型
     */
    var userType: String?
        get() = if (sLogin != null && !TextUtils.isEmpty(sLogin!!.user_type))
            sLogin!!.user_type
        else
            "1"
        set(userType) {
            val login = sLogin
            if (login != null) {
                login.user_type = userType
                setLoginData(login)
            }
        }

    /**
     * 当前用户是否是男
     *
     * @return 是否是男
     */
    val isMan: Boolean
        get() {
            val sex = sex
            return "1" == sex
        }

    /**
     * 当前用户是否是女
     *
     * @return 是否是女
     */
    val isWoman: Boolean
        get() {
            val sex = sex
            return "2" == sex
        }

    fun init() {
        sLogin = UserSPManager.loginData
    }

    /**
     * 用户登录成功后设置登录数据
     *
     * @param data 登录数据
     */
    fun setLoginData(data: UserBean) {
        sLogin = data
        //保存到SP
        UserSPManager.putLoginData(data)
    }

    /**
     * 用户登出、用户登录凭证失效时清除用户数据
     */
    fun clearUserData() {
        sLogin = null
        UserSPManager.clearUserData()
    }
}
