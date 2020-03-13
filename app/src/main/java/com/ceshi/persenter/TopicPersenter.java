package com.ceshi.persenter;

import com.ceshi.bean.TopicListBean;
import com.ceshi.module.CallBack;
import com.ceshi.module.TopicModule;
import com.ceshi.view.View;

public class TopicPersenter implements persenter{
    private View view;
    private TopicModule topicModule;

    public TopicPersenter(View view) {
        this.view = view;
        topicModule = new TopicModule();
    }

    @Override
    public void getdata() {
        topicModule.getdata(new CallBack() {
            @Override
            public void onSuccess(TopicListBean result) {
                view.getTopicListReturn(result);
            }
        });
    }
}
