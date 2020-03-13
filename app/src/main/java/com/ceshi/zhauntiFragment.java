package com.ceshi;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ceshi.bean.TopicBean;
import com.ceshi.bean.TopicListBean;
import com.ceshi.persenter.TopicPersenter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class zhauntiFragment extends Fragment implements com.ceshi.view.View {


    private RecyclerView mZhauntiRv;
    private ArrayList<TopicBean> dataBeans;
    private Zhauntiadapter adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_zhaunti, container, false);
        TopicPersenter topicPersenter = new TopicPersenter(this);
        topicPersenter.getdata();
        return inflate;
    }

    private void initView( View itemView) {
        mZhauntiRv = (RecyclerView) itemView.findViewById(R.id.rv_zhaunti);
        mZhauntiRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBeans = new ArrayList<>();
        adapter = new Zhauntiadapter(getActivity(),dataBeans);
        mZhauntiRv.setAdapter(adapter);
        adapter.setOnItemClickLis(new Zhauntiadapter.OnItemClickLis() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), dataBeans.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getTopicListReturn(TopicListBean result) {
        List<TopicListBean.DataBeanX.DataBean> data = result.getData().getData();
        ArrayList<TopicBean> topicBeans = new ArrayList<>();
        for (TopicListBean.DataBeanX.DataBean datum : data) {
            TopicBean topicBean = new TopicBean();
            topicBean.setTitle(datum.getTitle());
            topicBean.setUrl(datum.getScene_pic_url());
            topicBean.setSubtitle(datum.getSubtitle());
            topicBeans.add(topicBean);
        }
        adapter.updata(topicBeans);
    }
}
