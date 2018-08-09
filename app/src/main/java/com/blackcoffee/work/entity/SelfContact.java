package com.blackcoffee.work.entity;

import android.util.Log;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * Created by admin on 2018/5/30.
 * 类描述  获取到手机联系人之后 自行转化到本地的实体类
 * 版本
 */
public class SelfContact extends DataSupport implements IndexableEntity,Serializable {

    private int id;
    private long contactId;  //联系人id
    private String contactName; //联系人姓名
    private String avatuar; //联系人头像
    private String contactNo; //联系人电话
    private String pinYin;
    private String shortPinYin;

    public SelfContact(long contactId, String contactName, String avatuar, String contactNo) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.avatuar = avatuar;
        this.contactNo = contactNo;
    }





    public SelfContact(long contactId, String contactName, String avatuar, String contactNo, String pinYin, String shortPinYin) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.avatuar = avatuar;
        this.contactNo = contactNo;
        this.pinYin = pinYin;
        this.shortPinYin = shortPinYin;
    }

    public SelfContact() {
    }


    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getShortPinYin() {
        return shortPinYin;
    }

    public void setShortPinYin(String shortPinYin) {
        this.shortPinYin = shortPinYin;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAvatuar() {
        return avatuar;
    }

    public void setAvatuar(String avatuar) {
        this.avatuar = avatuar;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    @Override
    public String toString() {
        return "SelfContact{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", contactName='" + contactName + '\'' +
                ", avatuar='" + avatuar + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", pinYin='" + pinYin + '\'' +
                ", shortPinYin='" + shortPinYin + '\'' +
                '}';
    }

    @Override
    public String getFieldIndexBy() {
        return this.contactName ;
    }

    @Override
    public void setFieldIndexBy(String indexField) {
        this.contactName = indexField;
    }

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {

        Log.i("the_adapter_pintin",pinyin);
        this.pinYin = pinyin;
    }
}