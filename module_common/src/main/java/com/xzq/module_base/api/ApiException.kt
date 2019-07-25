package com.xzq.module_base.api

/**
 * 接口返回异常
 *
 * @author xzq
 */
class ApiException internal constructor(message: String, val code: Int) : Exception(message)
