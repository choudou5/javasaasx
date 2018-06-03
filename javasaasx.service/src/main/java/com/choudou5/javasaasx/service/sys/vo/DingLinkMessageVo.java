package com.choudou5.javasaasx.service.sys.vo;

import java.io.Serializable;

/**
 * @Name：钉钉链接消息
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
public class DingLinkMessageVo implements Serializable {

    private String messageUrl;
    private String picUrl;
    private String title;
    private String text;


    public DingLinkMessageVo() {
    }

    public DingLinkMessageVo(String messageUrl, String picUrl, String title, String text) {
        super();
        this.messageUrl = messageUrl;
        this.picUrl = picUrl;
        this.title = title;
        this.text = text;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String type() {
        return "link";
    }
}
