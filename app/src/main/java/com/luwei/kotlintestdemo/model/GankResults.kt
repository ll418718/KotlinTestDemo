package com.luwei.kotlintestdemo.model

/**
 * Created by SEELE on 2017/7/4.
 */
class GankResults : BaseModel(){

    var results: List<Item>? = null

    override fun isNull(): Boolean {
        return results == null || results!!.isEmpty()
    }

    class Item{
        var _id:String? = null
        var _ns: String? = null
        var createdAt: String? = null
        var desc: String? = null
        var publishedAt: String? = null
        var source: String? = null
        var type: String? = null
        var url: String? = null
        var used: String? = null
        var who: String? = null
    }
}
