package com.luwei.kotlintestdemo.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import cn.droidlover.xdroidmvp.kit.KnifeKit
import com.luwei.kotlintestdemo.R

/**
 * Created by SEELE on 2017/7/4.
 */
class StateView : LinearLayout {
    //val contentLayout : XRecyclerContentLayout by bindView(R.id.contentLayout)
    val tvMsg : TextView by bindView(R.id.tv_msg)
//    @BindView(R.id.tv_msg)
//    internal var tvMsg: TextView? = null
    constructor(context: Context) : super(context){
        setupView(context)
    }

    constructor(context: Context,attrs: AttributeSet) : super(context,attrs){
        setupView(context)
    }

    constructor(context: Context,attrs: AttributeSet,defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        setupView(context)
    }

    private fun setupView(context: Context) {
        View.inflate(context, R.layout.view_state,this)
        KnifeKit.bind(this)
    }

    fun setMsg(msg: String){
        if (!TextUtils.isEmpty(msg)){
            tvMsg!!.text = msg
        }
    }
}