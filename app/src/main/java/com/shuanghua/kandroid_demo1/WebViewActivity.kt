package com.shuanghua.kandroid_demo1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        intent.getStringExtra("NEWS_URL").let { textUrl.text = it }
    }

    companion object {
        fun getStartActivityIntent(context: Context): Intent {
            return Intent(context, WebViewActivity::class.java)
        }
    }
}