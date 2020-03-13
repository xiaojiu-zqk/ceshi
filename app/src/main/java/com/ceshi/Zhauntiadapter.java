package com.ceshi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ceshi.bean.TopicBean;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class Zhauntiadapter extends RecyclerView.Adapter<Zhauntiadapter.ViewHolder> {
    private Context basecontext;
    private List<TopicBean> data;
    private OnItemClickLis onItemClickLis;

    public void setOnItemClickLis(OnItemClickLis onItemLongClickLis) {
        this.onItemClickLis = onItemClickLis;
    }

    public Zhauntiadapter(Context basecontext, List<TopicBean> data) {
        this.basecontext = basecontext;
        this.data = data;
    }

    @NonNull
    @Override
    public Zhauntiadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(basecontext).inflate(R.layout.item_rv, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Zhauntiadapter.ViewHolder holder, int position) {
        TopicBean topicBean = data.get(position);
        Glide.with(basecontext).load(topicBean.getUrl()).into(holder.img);
        holder.title.setText(topicBean.getTitle());
        holder.subtitle.setText(topicBean.getSubtitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickLis.onItemClick(position);
            }
        });
    }
    public void updata(List<TopicBean> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView subtitle;
        private Button shoucang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_rv_zhuanti);
            title = itemView.findViewById(R.id.title_zhaunti);
            subtitle = itemView.findViewById(R.id.subtitle);
            shoucang = itemView.findViewById(R.id.btn_shoucang);
        }
    }
    public interface OnItemClickLis{
        void onItemClick(int position);
    }
}
