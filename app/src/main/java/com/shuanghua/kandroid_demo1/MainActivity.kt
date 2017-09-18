package com.shuanghua.kandroid_demo1

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shuanghua.kandroid_demo1.adapter.NewsAdapter
import com.shuanghua.kandroid_demo1.app.Const
import com.shuanghua.kandroid_demo1.bean.ListBean
import com.shuanghua.kandroid_demo1.bean.NewsBean
import com.shuanghua.kandroid_demo1.http.HttpService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var adapter: NewsAdapter? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        HttpService.service.getData(Const.APP_ID, Const.SECRET).enqueue(object : Callback<NewsBean> {
            override fun onFailure(call: Call<NewsBean>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<NewsBean>?, response: Response<NewsBean>?) {
                response?.body()?.showapi_res_body?.showapi_res_body?.list!!.let {
                    adapter?.setData(it)
                }
            }
        })
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        val list = listOf(ListBean("", "", ""))
        adapter = NewsAdapter(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        adapter?.setData(list)

        adapter!!.addOnClickListener(object : NewsAdapter.RecyclerViewClickListener {
            override fun onClick(view: View, position: Int, url: String) {
                WebViewActivity.getStartActivityIntent(this@MainActivity)
                        .putExtra("NEWS_URL", url)
                        .let { startActivity(it) }
            }
        })
    }
}