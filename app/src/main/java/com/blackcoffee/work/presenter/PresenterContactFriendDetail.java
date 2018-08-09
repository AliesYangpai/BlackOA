package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.IContactFriendDetialView;
import com.blackcoffee.work.ui.iview.IContactPhoneDetialView;
import com.blackcoffee.work.universal.function.FunctionSimCard;

/**
 * Created by admin on 2018/5/31.
 * 类描述  我的好友详情界面
 * 版本
 */
public class PresenterContactFriendDetail extends BasePresenter<IContactFriendDetialView> {

    private IContactFriendDetialView iContactFriendDetialView;

    private FunctionSimCard functionSimCard;

    public PresenterContactFriendDetail(IContactFriendDetialView iContactFriendDetialView) {
        this.iContactFriendDetialView = iContactFriendDetialView;
        this.functionSimCard = new FunctionSimCard();
    }


    /**
     * 处理电话的方法
     *
     * @param phone
     */
    public void doDealCall(String phone) {


        if (vertifyNotNull.isNullString(phone)) {

            iContactFriendDetialView.onVertifyErrorForNoPhoneNum();
            return;
        }

        iContactFriendDetialView.doGetTeleManager(phone);

    }


    /**
     * 处理打电话的方法
     *
     * @param statue
     * @param phone
     */
    public void doDealCallContinue(int statue, String phone) {

        if (!functionSimCard.isSimCardExist(statue)) {
            iContactFriendDetialView.onVertifyErrorForNoSimCard();
            return;
        }

        iContactFriendDetialView.doCall(phone);
    }

}