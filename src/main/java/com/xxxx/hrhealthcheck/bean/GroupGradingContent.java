package com.xxxx.hrhealthcheck.bean;

public class GroupGradingContent {
    private String content;

    public GroupGradingContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "GroupGradingContent{" +
                "content='" + content + '\'' +
                '}';
    }
}
