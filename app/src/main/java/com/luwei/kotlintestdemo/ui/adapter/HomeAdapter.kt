package com.luwei.kotlintestdemo.ui.adapter

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cn.droidlover.xdroidmvp.base.SimpleRecAdapter
import cn.droidlover.xdroidmvp.imageloader.ILFactory
import com.luwei.kotlintestdemo.R
import com.luwei.kotlintestdemo.model.GankResults

/**
 * Created by SEELE on 2017/7/4.
 */
class HomeAdapter(context: Context) : SimpleRecAdapter<GankResults.Item,HomeAdapter.ViewHolder>(context){
    override fun getLayoutId(): Int {
        return R.layout.adapter_home
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        val type = item.type
        when(type){
            "休息视频" -> {
                holder.rlMessage!!.visibility = View.VISIBLE
                holder.ivPart!!.visibility = View.GONE
                holder.ivVedio!!.visibility = View.VISIBLE
                holder.tvItem!!.text = item.desc
                holder.itemView.setOnClickListener {
                    if (recItemClick != null){

                    }
                }
            }
            "福利" ->{
                holder.rlMessage!!.visibility = View.GONE
                holder.ivPart!!.visibility = View.VISIBLE
                holder.ivVedio!!.visibility = View.GONE

                ILFactory.getLoader().loadNet(holder.ivPart,item.url,null)
                holder.tvItem!!.text = "瞧瞧妹纸，扩展扩展视野......"
                holder.itemView.setOnClickListener {
                    if (recItemClick != null){

                    }
                }
            }
            else ->{
                holder.rlMessage!!.visibility = View.VISIBLE
                holder.ivPart!!.visibility = View.GONE
                holder.ivVedio!!.visibility = View.GONE
                holder.tvItem!!.text = item.desc
                holder.itemView.setOnClickListener {
                    if (recItemClick != null){

                    }
                }
            }
        }

        val uri: Uri? = null
        when(item.type){
            "Android" -> holder.ivType!!.setImageResource(R.mipmap.android_icon)
            "iOS" -> holder.ivType!!.setImageResource(R.mipmap.ios_icon)
            "前端" -> holder.ivType!!.setImageResource(R.mipmap.js_icon)
            "拓展资源" ->holder.ivType!!.setImageResource(R.mipmap.other_icon)
        }

        val author = item.who
        if (author != null){
            holder.tvAuthor!!.text = author
            holder.tvAuthor!!.setTextColor(Color.parseColor("#87000000"))
        } else{
            holder.tvAuthor!!.text = ""
        }
        holder.tvTime!!.text = item.createdAt

        holder.tvType!!.text = type

        holder.itemView.setOnClickListener {
            if (recItemClick != null){
                recItemClick.onItemClick(position,item, TAG_VIEW,holder)
            }
        }
    }

    override fun newViewHolder(itemView: View): ViewHolder {
       return ViewHolder(itemView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var ivType: ImageView
        internal var tvType: TextView
        internal var ivAuthor: ImageView
        internal var tvAuthor: TextView
        internal var tvTime: TextView
        internal var rlMessage: RelativeLayout
        internal var ivPart: ImageView
        internal var ivVedio: ImageView
        internal var tvItem: TextView

//        @BindView(R.id.iv_type)
//        internal var ivType: ImageView? = null
//        @BindView(R.id.tv_type)
//        internal var tvType: TextView? = null
//        @BindView(R.id.iv_author)
//        internal var ivAuthor: ImageView? = null
//        @BindView(R.id.tv_author)
//        internal var tvAuthor: TextView? = null
//        @BindView(R.id.tv_time)
//        internal var tvTime: TextView? = null
//        @BindView(R.id.rl_message)
//        internal var rlMessage: RelativeLayout? =null
//        @BindView(R.id.iv_part)
//        internal var ivPart: ImageView? = null
//        @BindView(R.id.iv_vedio)
//        internal var ivVedio: ImageView? = null
//        @BindView(R.id.tv_item)
//        internal var tvItem: TextView? = null
//val nameEditText: EditText by bindView(R.id.name_edit_text)


        init {
            ivType = itemView.findViewById(R.id.iv_type)
            tvType = itemView.findViewById(R.id.tv_type)
            ivAuthor = itemView.findViewById(R.id.iv_author)
            tvAuthor = itemView.findViewById(R.id.tv_author)
            tvTime = itemView.findViewById(R.id.tv_time)
            rlMessage = itemView.findViewById(R.id.rl_message)
            ivPart = itemView.findViewById(R.id.iv_part)
            ivVedio = itemView.findViewById(R.id.iv_vedio)
            tvItem = itemView.findViewById(R.id.tv_item)
        }
    }

    companion object{
        val TAG_VIEW = 0
    }
}