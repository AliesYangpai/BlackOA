package com.blackcoffee.work.presenter;


import com.blackcoffee.work.ui.iview.IContactAddFriendView;

/**
 * Created by admin on 2018/5/30.
 * 类描述 我的好友界面  添加的FriendView
 * 版本
 */
public class PresenterContactAddFriend extends BasePresenter<IContactAddFriendView> {


    private  IContactAddFriendView iContactAddFriendView;

    public PresenterContactAddFriend(IContactAddFriendView iContactAddFriendView) {
        this.iContactAddFriendView = iContactAddFriendView;
    }



    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode,String... permissions) {

        iContactAddFriendView.doPermissionCheck(requestCode,permissions);

    }



    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iContactAddFriendView.doShowPermissionDialog();
    }
}