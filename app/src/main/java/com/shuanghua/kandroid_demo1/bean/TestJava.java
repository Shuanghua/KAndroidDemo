package com.shuanghua.kandroid_demo1.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestJava {

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBeanX showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBeanX getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBeanX showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBeanX {

        private String showapi_res_error;
        private int showapi_res_code;
        private String msg;
        private ShowapiResBodyBean showapi_res_body;

        public String getShowapi_res_error() {
            return showapi_res_error;
        }

        public void setShowapi_res_error(String showapi_res_error) {
            this.showapi_res_error = showapi_res_error;
        }

        public int getShowapi_res_code() {
            return showapi_res_code;
        }

        public void setShowapi_res_code(int showapi_res_code) {
            this.showapi_res_code = showapi_res_code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ShowapiResBodyBean getShowapi_res_body() {
            return showapi_res_body;
        }

        public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
            this.showapi_res_body = showapi_res_body;
        }

        public static class ShowapiResBodyBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {

                private String title;
                private String day;
                @SerializedName("long")
                private String longX;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getLongX() {
                    return longX;
                }

                public void setLongX(String longX) {
                    this.longX = longX;
                }
            }
        }
    }
}