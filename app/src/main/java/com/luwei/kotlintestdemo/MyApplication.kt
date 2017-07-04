package com.luwei.kotlintestdemo

import android.app.Application
import android.content.Context
import cn.droidlover.xdroidmvp.net.NetError
import cn.droidlover.xdroidmvp.net.NetProvider
import cn.droidlover.xdroidmvp.net.RequestHandler
import cn.droidlover.xdroidmvp.net.XApi
import okhttp3.CookieJar
import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Created by SEELE on 2017/7/4.
 */
class MyApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        XApi.registerProvider(object : NetProvider{
            override fun configInterceptors(): Array<Interceptor?> {
                return arrayOfNulls(0)
            }

            override fun configHandler(): RequestHandler? {
                return null
            }

            override fun configLogEnable(): Boolean {
                return true
            }

            override fun configCookie(): CookieJar? {
                return null
            }

            override fun configHttps(builder: OkHttpClient.Builder?) {

            }

            override fun configConnectTimeoutMills(): Long {
                return 0
            }

            override fun configReadTimeoutMills(): Long {
                return 0
            }

            override fun handleError(error: NetError?): Boolean {
                return false
            }
        })
    }

    companion object {

        var context: Context? = null
            private set
    }
}