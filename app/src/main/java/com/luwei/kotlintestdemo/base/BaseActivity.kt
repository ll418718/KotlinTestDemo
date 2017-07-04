package com.luwei.kotlintestdemo.base

import android.app.ProgressDialog
import android.widget.Toast
import cn.droidlover.xdroidmvp.log.XLog
import cn.droidlover.xdroidmvp.mvp.XActivity
import cn.droidlover.xdroidmvp.mvp.XPresent
import java.lang.Exception

/**
 * Created by SEELE on 2017/7/3.
 */
abstract class BaseActivity<P : XPresent<*>> : XActivity<P>() {

    private var progressDialog: ProgressDialog? = null

    /**
     * 显示菊花
     */
    fun showDialog(msg: String){
        try{
            progressDialog = ProgressDialog(this)
            progressDialog!!.setMessage(msg)
            progressDialog!!.show()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    /**
     * 隐藏菊花
     */
    fun dissDialog(){
        if(progressDialog != null && progressDialog!!.isShowing){
            progressDialog!!.dismiss()
        }
    }

    fun showTs(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    fun showLog(message: String){
        XLog.e("test-----",message)
    }
}