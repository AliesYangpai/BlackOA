package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IContactAddView;

/**
 * Created by admin on 2018/5/30.
 * 类描述 联系人 添加的view
 * 版本
 */
public class PresenterContactAdd extends BasePresenter<IContactAddView> {


    private  IContactAddView iContactAddView;

    public PresenterContactAdd(IContactAddView iContactAddView) {
        this.iContactAddView = iContactAddView;
    }



    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode,String... permissions) {

        iContactAddView.doPermissionCheck(requestCode,permissions);

    }



    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iContactAddView.doShowPermissionDialog();
    }
}