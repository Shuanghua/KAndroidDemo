package com.shuanghua.kandroid_demo1.bean

import com.google.gson.annotations.SerializedName


data class NewsBean(var showapi_res_code: Int = 0,
                    var showapi_res_error: String? = null,
                    var showapi_res_body: ShowapiResBodyBeanX? = null)

data class ShowapiResBodyBeanX(var showapi_res_error: String? = null,
                               var showapi_res_code: Int = 0,
                               var msg: String? = null,
                               var showapi_res_body: ShowapiResBodyBean? = null)

data class ShowapiResBodyBean(var list: List<ListBean>? = null)

data class ListBean(var title: String? = null,
                    var day: String? = null,
                    @SerializedName("long") var url: String? = null)
