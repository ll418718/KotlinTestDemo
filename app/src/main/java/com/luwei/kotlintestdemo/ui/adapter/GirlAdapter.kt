package com.luwei.kotlintestdemo.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xdroidmvp.imageloader.ILFactory
import com.luwei.kotlintestdemo.R
import com.luwei.kotlintestdemo.model.GankResults

/**
 * Created by SEELE on 2017/7/4.
 */
class GirlAdapter(context: Context): SimpleRecAdapter<GankResults.Item,GirlAdapter.ViewHolder>(context) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        ILFactory.getLoader().loadNet(holder.ivGirl,item.url,null)

        holder.itemView.setOnClickListener {
            if (recItemClick != null){
                recItemClick.onItemClick(position,item,0,holder)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.adapter_girl
    }

    override fun newViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        /*@BindView(R.id.iv_girl)
        internal var ivGirl: ImageView? = null*/
        internal var ivGirl: ImageView


        init {
            ivGirl = itemView.findViewById(R.id.iv_girl)
           // KnifeKit.bind(this,itemView)
        }
    }
}