package com.blackcoffee.work.presenter;

import com.blackcoffee.work.constant.ConstError;
import com.blackcoffee.work.constant.ConstSp;
import com.blackcoffee.work.entity.ErrorEntity;
import com.blackcoffee.work.entity.TokenInfo;
import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.logic.LogicUser;
import com.blackcoffee.work.method.IUser;
import com.blackcoffee.work.method.impl.IUserImpl;
import com.blackcoffee.work.ui.iview.ILoginView;
import com.blackcoffee.work.universal.cache.sp.SpUtil;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by admin on 2018/5/8.
 * 类描述
 * 版本
 */
public class PresenterLogin extends BasePresenter<ILoginView> {


    private ILoginView iLoginView;
    private IUser iUser;
    private LogicUser logicUser;

    public PresenterLogin(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        this.iUser = new IUserImpl();
        this.logicUser = new LogicUser();
    }

    /**
     * 用户登录
     * @param url
     * @param user_name
     * @param passWord
     */
    public void doLogin(String url,String user_name,String passWord) {

        if(vertifyNotNull.isNullString(user_name)) {

            iLoginView.onVertifyErrorNullUserName();
            return;
        }

        if(!logicUser.isLegalPhone(user_name)) {

            iLoginView.onVertifyErrorUnlegalUserName();
            return;
        }

        if(vertifyNotNull.isNullString(passWord)) {

            iLoginView.onVertifyErrorNullPassWord();
            return;
        }

        if(!logicUser.isLegalPass(passWord)) {

            iLoginView.onVertifyErrorUnlegalPassWord();
            return;
        }


        iUser.doLogon(url, user_name, passWord, new OnDataBackListener() {
            @Override
            public void onStart() {

                iLoginView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {

                TokenInfo tokenInfo = parseSerilizable.getParseToObj(data, TokenInfo.class);
                if (vertifyNotNull.isNotNullObj(tokenInfo)) {
                    SpUtil.getInstance().saveStringToSp(ConstSp.SP_KEY_TOKEN, tokenInfo.getAccess_token());
                    SpUtil.getInstance().saveBooleanTosp(ConstSp.SP_KEY_IS_LOGIN, ConstSp.SP_VALUE.IS_LOGIN);
                    iLoginView.onDataBackSuccessForLogon(tokenInfo);

                } else {

                    iLoginView.onDataBackFail(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);
                }
            }

            @Override
            public void onFail(int code, String data) {


                ErrorEntity errorEntity = parseSerilizable.getParseToObj(data, ErrorEntity.class);
                if (vertifyNotNull.isNotNullObj(errorEntity)) {
                    iLoginView.onDataBackFail(code, errorEntity.getError_message());
                } else {
                    iLoginView.onDataBackFail(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);
                }
            }

            @Override
            public void onFinish() {
                iLoginView.dismissLoadingDialog();
            }
        });

    }


    /**
     * 获取用户信息
     * @param url
     */
    public void doGetUserInfo(String url) {

        iUser.doGetUserInfo(url, new OnDataBackListener() {
            @Override
            public void onStart() {
                iLoginView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {


                /**
                 * 用户信息获取成功
                 */

            }

            @Override
            public void onFail(int code, String data) {
                ErrorEntity errorEntity = parseSerilizable.getParseToObj(data, ErrorEntity.class);
                if (vertifyNotNull.isNotNullObj(errorEntity)) {
                    iLoginView.onDataBackFail(code, errorEntity.getError_message());
                } else {
                    iLoginView.onDataBackFail(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);
                }
            }

            @Override
            public void onFinish() {

                iLoginView.dismissLoadingDialog();
            }
        });


    }

}