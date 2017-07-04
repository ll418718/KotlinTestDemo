package com.luwei.kotlintestdemo.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xrecyclerview.RecyclerItemCallback
import cn.droidlover.xrecyclerview.XRecyclerContentLayout
import com.luwei.kotlintestdemo.base.BasePageFragment
import com.luwei.kotlintestdemo.model.GankResults
import com.luwei.kotlintestdemo.ui.activity.SeeBeautyActivity
import com.luwei.kotlintestdemo.ui.adapter.GirlAdapter

/**
 * Created by SEELE on 2017/7/4.
 */
class GirlListFragment : BasePageFragment() {
    private var girlAdapter: GirlAdapter? = null

    override val type: String
        get() = "福利"

    override val adapter: SimpleRecAdapter<GankResults.Item, *>
        get() {
            if (girlAdapter == null){
                girlAdapter = GirlAdapter(context)
            }
            girlAdapter!!.recItemClick = object : RecyclerItemCallback<GankResults.Item,GirlAdapter.ViewHolder>(){
                override fun onItemClick(position: Int, model: GankResults.Item?, tag: Int, holder: GirlAdapter.ViewHolder?) {
                    super.onItemClick(position, model, tag, holder)
                    SeeBeautyActivity.toSeeBeauty(activity,model!!.url!!)
                }
            }
            return girlAdapter!!
        }

    override fun setLayoutManager(contentLayout: XRecyclerContentLayout) {
        contentLayout.recyclerView.layoutManager = GridLayoutManager(context,2)
    }
    companion object {

        fun newInstance(): GirlListFragment{
            val args = Bundle()
            val fragment = GirlListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}