package com.luwei.kotlintestdemo

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import butterknife.bindView
import cn.droidlover.xdroidmvp.base.XFragmentAdapter
import com.luwei.kotlintestdemo.base.BaseActivity
import com.luwei.kotlintestdemo.presenter.MainPresenter
import com.luwei.kotlintestdemo.ui.fragment.GankListFragment
import com.luwei.kotlintestdemo.ui.fragment.GirlListFragment
import com.luwei.kotlintestdemo.ui.fragment.HomeListFragment

class MainActivity : BaseActivity<MainPresenter>() {
    val rabMenu : TabLayout by bindView(R.id.rab_menu)
    val vpContent : ViewPager by bindView(R.id.vp_content)
    val toolbar : Toolbar by bindView(R.id.toolbar)
   /* @BindView(R.id.rab_menu)
    internal var rabMenu: TabLayout? = null
    @BindView(R.id.vp_content)
    internal var vpContent: ViewPager? = null
    @BindView(R.id.toolbar)
    internal var toolbar: Toolbar? = null*/

    private val fragmentList = ArrayList<Fragment>()
    private val titleArr = arrayOf("首页","干货","美女")

    override fun initData(savedInstanceState: Bundle?) {

       // val toolbar = findViewById(R.id.toolbar) as Toolbar
        //val vpContent=findViewById(R.id.vp_content) as ViewPager
       // val rabMenu = findViewById(R.id.rab_menu) as TabLayout
        setSupportActionBar(toolbar)
        fragmentList.add(HomeListFragment.newInstance())
        fragmentList.add(GankListFragment.newInstance())
        fragmentList.add(GirlListFragment.newInstance())
        vpContent.offscreenPageLimit = fragmentList.size - 1
        vpContent.adapter = XFragmentAdapter(supportFragmentManager,fragmentList,titleArr)
        rabMenu.setupWithViewPager(vpContent)
    }

    override fun newP(): MainPresenter {
        return MainPresenter()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
