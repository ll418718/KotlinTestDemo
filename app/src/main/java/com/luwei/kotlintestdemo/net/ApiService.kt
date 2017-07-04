package com.luwei.kotlintestdemo.net

import com.luwei.kotlintestdemo.model.GankResults
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by SEELE on 2017/7/4.
 */
interface ApiService {
    @GET("data/{type}/{number}/{page}")
    fun getGankData(@Path("type") type: String,
                    @Path("number") pageSize: Int,
                    @Path("page") pageNum: Int): Flowable<GankResults>
}