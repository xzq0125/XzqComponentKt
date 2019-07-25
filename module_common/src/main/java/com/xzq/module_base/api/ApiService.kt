package com.xzq.module_base.api

import com.xzq.module_base.bean.HomePageBean
import io.reactivex.Observable
import retrofit2.http.*

/**
 * ApiService
 * Created by Wesley on 2018/7/10.
 */
interface ApiService {

    /**
     * method：网络请求的方法（区分大小写）
     * path：网络请求地址路径
     * hasBody：是否有请求体
     */
    @HTTP(method = "GET", path = "/article/list/{page}/json", hasBody = false)
    fun getWangAndroidHomePage(
        @Path("page") page: Int
    ): Observable<NetBean<BaseListBean<HomePageBean>>>

    @FormUrlEncoded
    @POST("/yingbao/api/msg/validate")
    fun validateCode(
        @Field("mobile") mobile: String,
        @Field("code") code: String
    ): Observable<NetBean<Any>>

    @FormUrlEncoded
    @POST("/yingbao/api/member/mobilelogin")
    fun login(
        @Field("mobile") mobile: String,
        @Field("registerSrc") registerSrc: String,
        @Field("nickname") nickname: String,
        @Field("bindNo") bindNo: String
    ): Observable<NetBean<Any>>
}
