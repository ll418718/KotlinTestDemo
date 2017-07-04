package com.luwei.kotlintestdemo.base

import android.os.Bundle
import android.view.View
import butterknife.bindView
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xdroidmvp.mvp.XFragment
import cn.droidlover.xdroidmvp.net.NetError
import cn.droidlover.xrecyclerview.XRecyclerContentLayout
import cn.droidlover.xrecyclerview.XRecyclerView
import com.luwei.kotlintestdemo.R
import com.luwei.kotlintestdemo.model.GankResults
import com.luwei.kotlintestdemo.presenter.ListPresenter
import com.luwei.kotlintestdemo.widget.StateView

/**
 * Created by SEELE on 2017/7/4.
 */
abstract class BasePageFragment : XFragment<ListPresenter>(){
//    val rabMenu : TabLayout by bindView(R.id.rab_menu)
    val contentLayout : XRecyclerContentLayout by bindView(R.id.contentLayout)
    /*@BindView(R.id.contentLayout)
    internal var contentLayout: XRecyclerContentLayout? = null*/
    internal var errorView: StateView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_list
    }

    override fun newP(): ListPresenter {
        return ListPresenter()
    }

    override fun initData(savedInstanceState: Bundle?) {
        initAdapter()
        p.loadData(type, 1)
    }

    private fun initAdapter() {
        setLayoutManager(contentLayout!!)
        if (errorView == null){
            errorView = StateView(context)
        }
        contentLayout!!.recyclerView.setAdapter(adapter)
        contentLayout!!.errorView(errorView)
        contentLayout!!.loadingView(View.inflate(getContext(),R.layout.view_loading,null))
        contentLayout!!.recyclerView.useDefLoadMoreView()
        contentLayout!!.recyclerView.onRefreshAndLoadMoreListener = object : XRecyclerView.OnRefreshAndLoadMoreListener{
            override fun onRefresh() {
                p.loadData(type,1)
            }

            override fun onLoadMore(page: Int) {
                p.loadData(type,page)
            }
        }
    }

    fun  showError(error: NetError?) {
        if (error != null){
            when(error.type){
                NetError.ParseError -> errorView!!.setMsg(getString(R.string.data_parse_error))

                NetError.AuthError -> errorView!!.setMsg(getString(R.string.auth_check_error))

                NetError.BusinessError -> errorView!!.setMsg(getString(R.string.business_error))

                NetError.NoConnectError -> errorView!!.setMsg(getString(R.string.no_connect_error))

                NetError.NoDataError -> errorView!!.setMsg(getString(R.string.no_data_error))

                NetError.OtherError -> errorView!!.setMsg(getString(R.string.other_error))
            }
            contentLayout!!.showError()
        }
    }
    fun  showData(page: Int, gankResults: GankResults) {
        if (page > 1){
            adapter.addData(gankResults.results)
        } else{
            adapter.setData(gankResults.results)
        }
        contentLayout!!.recyclerView.setPage(page,10)

        if (adapter.itemCount < 1){
            contentLayout!!.showEmpty()
            return
        }
    }

    protected abstract val  type: String

    protected abstract val  adapter: SimpleRecAdapter<GankResults.Item,*>

    protected abstract fun setLayoutManager(contentLayout: XRecyclerContentLayout)

}