package com.luwei.kotlintestdemo.net

import cn.droidlover.xdroidmvp.net.XApi

/**
 * Created by SEELE on 2017/7/4.
 */
object HttpRequest {

    val apiBaseUrl = "http://gank.io/api/"

    private var apiService: ApiService? = null

    fun getApiService(): ApiService{
        if (apiService == null){
            synchronized(HttpRequest::class.java){
                if (apiService == null){
                    apiService = XApi.getInstance().getRetrofit(apiBaseUrl,true).create(ApiService::class.java)
                }
            }
        }
        return apiService!!
    }
}