package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.entity.TokenInfo;
import com.blackcoffee.work.ui.IBaseView;

/**
 * Created by admin on 2018/5/8.
 * 类描述  登录的IVew
 * 版本
 */
public interface ILoginView extends IBaseView{


    void onVertifyErrorNullUserName();

    void onVertifyErrorUnlegalUserName();

    void onVertifyErrorNullPassWord();

    void onVertifyErrorUnlegalPassWord();


    /**
     * 登录成功
     * @param tokenInfo
     */
    void onDataBackSuccessForLogon(TokenInfo tokenInfo);



}