package com.luwei.kotlintestdemo.ui.activity

import android.app.Activity
import android.os.Bundle
import butterknife.bindView
import cn.droidlover.xdroidmvp.imageloader.ILFactory
import cn.droidlover.xdroidmvp.mvp.XPresent
import cn.droidlover.xdroidmvp.router.Router
import com.luwei.kotlintestdemo.R
import com.luwei.kotlintestdemo.base.BaseActivity
import uk.co.senab.photoview.PhotoView

class SeeBeautyActivity : BaseActivity<XPresent<*>>() {

    val pvBeautyPic: PhotoView by bindView(R.id.pv_beauty_pic)
//    @BindView(R.id.pv_beauty_pic)
//    internal var pvBeautyPic: PhotoView? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_see_beauty
    }

    override fun newP(): XPresent<*>? {
        return null
    }

    override fun initData(savedInstanceState: Bundle?) {
        val url = intent.getStringExtra("url")
        ILFactory.getLoader().loadNet(pvBeautyPic,url,null)
    }

    companion object {

        fun toSeeBeauty(activity: Activity,url: String){
            Router.newIntent(activity).to(SeeBeautyActivity::class.java).putString("url",url).launch()
        }
    }


}
