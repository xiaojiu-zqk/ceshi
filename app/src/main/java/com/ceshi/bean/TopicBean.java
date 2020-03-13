package com.ceshi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TopicBean {
    @Id    
    private Long id;
    private String title;
    private String  url;
    private String subtitle;
    @Generated(hash = 1632289904)
    public TopicBean(Long id, String title, String url, String subtitle) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.subtitle = subtitle;
    }
    @Generated(hash = 1961217991)
    public TopicBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getSubtitle() {
        return this.subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
