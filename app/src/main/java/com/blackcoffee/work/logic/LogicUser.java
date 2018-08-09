package com.blackcoffee.work.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/5/8.
 * 类描述  用户相关逻辑类
 * 版本
 */
public class LogicUser {


    /**
     * 合法电话号码
     * @param param
     * @return
     */
    public boolean isLegalPhone(String param) {
        String strPattern = "[1][345678]\\d{9}";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(param);
        return m.matches();

    }

    /**
     * 密码合法性
     * 字母、数字（无字母开头限制）8-16个字符之间
     */

    public boolean isLegalPass(String pass) {

        String strPattern = "(?!^\\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{8,16}$";

        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(pass);
        return m.matches();
    }


}