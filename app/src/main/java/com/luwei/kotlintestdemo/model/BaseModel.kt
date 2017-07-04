package com.luwei.kotlintestdemo.model

import cn.droidlover.xdroidmvp.net.IModel

/**
 * Created by SEELE on 2017/7/4.
 */
open class BaseModel : IModel{
    var isError: Boolean = false

    override fun isNull(): Boolean {
        return false
    }

    override fun isAuthError(): Boolean {
        return false
    }

    override fun isBizError(): Boolean {
        return isError
    }

    override fun getErrorMsg(): String? {
        return null
    }
}