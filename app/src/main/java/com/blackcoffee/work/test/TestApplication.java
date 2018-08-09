package com.blackcoffee.work.test;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by admin on 2018/5/21.
 * 类描述
 * 版本
 */
public class TestApplication  {

    private String titleName;
    private String itemName;
    private String itemUrl;
    private int itemDrawableId;
    private String typeTag;//所属的type类型
    private String localTag;


    public TestApplication(String itemName, String localTag) {
        this.itemName = itemName;
        this.localTag = localTag;
    }


    public TestApplication(String titleName, String itemName, String itemUrl, int itemDrawableId) {
        this.titleName = titleName;
        this.itemName = itemName;
        this.itemUrl = itemUrl;
        this.itemDrawableId = itemDrawableId;
    }




    public TestApplication(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public int getItemDrawableId() {
        return itemDrawableId;
    }

    public void setItemDrawableId(int itemDrawableId) {
        this.itemDrawableId = itemDrawableId;
    }


    public String getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(String typeTag) {
        this.typeTag = typeTag;
    }

    public String getLocalTag() {
        return localTag;
    }

    public void setLocalTag(String localTag) {
        this.localTag = localTag;
    }
}