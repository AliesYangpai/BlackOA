package com.blackcoffee.work.constant;

/**
 * Created by admin on 2018/5/31.
 * 类描述
 * 版本
 */
public class ConstSQL {


    public static final String AND = " and ";//这里一定要以空格空开
    public static final String OR = " or ";//这里一定要以空格空开

    /**
     * bundleKey
     */
    public class SelfContact {
        public static final String FUZZY_CONTACT_NAME = "contactName like ?";//名称的模糊语句
        public static final String FUZZY_CONTACT_PHONE_NO = "contactNo like ?";//电话的模糊语句
        public static final String FUZZY_CONTACT_PINYIN = "pinYin like ?";//拼音的模糊语句
        public static final String FUZZY_CONTACT_SHORT_PINYIN = "shortPinYin like ?";//拼音 简拼的模糊语句



    }
}