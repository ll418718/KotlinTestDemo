package com.luwei.kotlintestdemo.presenter

import cn.droidlover.xdroidmvp.log.XLog
import cn.droidlover.xdroidmvp.mvp.XPresent
import cn.droidlover.xdroidmvp.net.ApiSubscriber
import cn.droidlover.xdroidmvp.net.NetError
import cn.droidlover.xdroidmvp.net.XApi
import com.luwei.kotlintestdemo.base.BasePageFragment
import com.luwei.kotlintestdemo.model.GankResults
import com.luwei.kotlintestdemo.net.HttpRequest

/**
 * Created by SEELE on 2017/7/4.
 */
class ListPresenter : XPresent<BasePageFragment>(){
    //伴生对象，类似于静态对象
    companion object{
        protected val PAGE_SIZE = 10
    }
    fun loadData(type: String,page: Int){
        HttpRequest.getApiService().getGankData(type, PAGE_SIZE,page)
                .compose(XApi.getApiTransformer<GankResults>())
                .compose(XApi.getScheduler<GankResults>())
                .compose(v.bindToLifecycle<GankResults>())
                .subscribe(object : ApiSubscriber<GankResults>(){
                    override fun onFail(error: NetError) {
                        error.printStackTrace()
                        XLog.e("-------"+error.message)
                        v.showError(error)
                    }
                    override fun onNext(gankResults: GankResults) {
                        v.showData(page,gankResults)
                    }
                })
    }
}