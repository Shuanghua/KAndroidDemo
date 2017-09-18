package com.shuanghua.kandroid_demo1.bean

import com.google.gson.annotations.SerializedName

class TestKotlin {

    var showapi_res_code: Int = 0
    var showapi_res_error: String? = null
    var showapi_res_body: ShowapiResBodyBeanX? = null

    class ShowapiResBodyBeanX {

        var showapi_res_error: String? = null
        var showapi_res_code: Int = 0
        var msg: String? = null
        var showapi_res_body: ShowapiResBodyBean? = null

        class ShowapiResBodyBean {
            var list: List<ListBean>? = null

            class ListBean {
                var title: String? = null
                var day: String? = null
                @SerializedName("long")
                var longX: String? = null
            }
        }
    }
}
