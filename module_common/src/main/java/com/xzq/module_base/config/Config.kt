package com.xzq.module_base.config

/**
 * 全局配置
 * Created by Wesley on 2018/7/9.
 */

interface Config {
    companion object {
        // 缓存加密密码
        const val CACHE_PASSWORD = "\u2605\u2721\u2606\u263C\u00A7\u2603"
        // 缓存加密盐
        const val CACHE_SALT = "=?UTF-8?B?OSozajloY2VqbjQmZzI4Mg==?="
    }
}
