package com.luwei.kotlintestdemo.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xrecyclerview.RecyclerItemCallback
import cn.droidlover.xrecyclerview.XRecyclerContentLayout
import com.luwei.kotlintestdemo.base.BasePageFragment
import com.luwei.kotlintestdemo.model.GankResults
import com.luwei.kotlintestdemo.ui.adapter.HomeAdapter
import com.ly.javademo.ui.activity.SeeWebViewActivity

/**
 * Created by SEELE on 2017/7/4.
 */
class HomeListFragment : BasePageFragment(){

    private var homeAdapter: HomeAdapter? = null

    override val type: String
        get() = "all"

    override val adapter: SimpleRecAdapter<GankResults.Item, *>
        get() {
            if (homeAdapter == null){
                homeAdapter = HomeAdapter(context)
            }
            homeAdapter!!.recItemClick = object : RecyclerItemCallback<GankResults.Item,HomeAdapter.ViewHolder>(){
                override fun onItemClick(position: Int, model: GankResults.Item?, tag: Int, holder: HomeAdapter.ViewHolder?) {
                    super.onItemClick(position, model, tag, holder)
                    SeeWebViewActivity.toSeeWebView(activity,model!!.url!!,model.desc!!)
                }
            }
            return homeAdapter!!
        }

    override fun setLayoutManager(contentLayout: XRecyclerContentLayout) {
        contentLayout.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    companion object {

        fun newInstance(): HomeListFragment {
            val args = Bundle()
            val fragment = HomeListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}