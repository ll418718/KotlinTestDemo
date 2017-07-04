package com.luwei.kotlintestdemo.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xrecyclerview.XRecyclerContentLayout
import com.luwei.kotlintestdemo.base.BasePageFragment
import com.luwei.kotlintestdemo.model.GankResults
import com.luwei.kotlintestdemo.ui.adapter.HomeAdapter

/**
 * Created by SEELE on 2017/7/4.
 */
class GankListFragment : BasePageFragment() {

    private var homeAdapter: HomeAdapter? = null


    override val type: String
        get() = "福利"

    override val adapter: SimpleRecAdapter<GankResults.Item, *>
        get() {
            if (homeAdapter == null){
                homeAdapter = HomeAdapter(context)
            }
            return homeAdapter!!
        }

    override fun setLayoutManager(contentLayout: XRecyclerContentLayout) {
        contentLayout.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    companion object {

        fun newInstance(): GankListFragment{
            val args = Bundle()
            val fragment = GankListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}