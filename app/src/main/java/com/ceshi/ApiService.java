package com.ceshi;

import com.ceshi.bean.TopicListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

    public interface ApiService {
    String BASE_URL = "https://cdwan.cn/api/";

    @GET("topic/list")
    Observable<TopicListBean> getData();
}
