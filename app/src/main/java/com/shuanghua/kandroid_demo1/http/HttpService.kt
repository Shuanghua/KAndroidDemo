package com.shuanghua.kandroid_demo1.http

import com.shuanghua.kandroid_demo1.app.Const
import com.shuanghua.kandroid_demo1.bean.NewsBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object HttpService {
    val service by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(Const.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(Service::class.java)
    }
}

interface Service {
    @GET("1071-1")
    fun getData(@Query("showapi_appid") showapi_appid: String, @Query("showapi_sign") showapi_sign: String): Call<NewsBean>
}
