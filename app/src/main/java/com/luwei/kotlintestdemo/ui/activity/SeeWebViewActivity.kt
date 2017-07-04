package com.ly.javademo.ui.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import cn.droidlover.xdroidmvp.router.Router
import com.luwei.kotlintestdemo.R
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.webView

class SeeWebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent.getStringExtra("url")
        val desc = intent.getStringExtra("desc")
        verticalLayout{
            val mToolBar = toolbar {
            }
            setSupportActionBar(mToolBar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp)
            supportActionBar?.title = desc
        }
        webView {
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }
        
    }
    companion object {
        fun toSeeWebView(activity: Activity,url: String,desc: String){
            Router.newIntent(activity).to(SeeWebViewActivity::class.java).putString("url",url).putString("desc",desc).launch()
        }
    }
}
