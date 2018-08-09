package com.blackcoffee.work.entity.temp;

/**
 * Created by admin on 2018/6/7.
 * 类描述  添加图片的缓存实体类
 * 版本
 */
public class FileAdd {

    private String url;
    private String tag; // Add ; delete

    public FileAdd(String url, String tag) {
        this.url = url;
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "FileAdd{" +
                "url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}