package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgContactGroupsMyInvitedView;

/**
 * Created by admin on 2018/6/1.
 * 类描述  我的群组中 “我加入的” presenter
 * 版本
 */
public class PresenterFgContactGroupsMyInvite extends BasePresenter<IFgContactGroupsMyInvitedView> {

    private IFgContactGroupsMyInvitedView iFgContactGroupsMyInvitedView;


    public PresenterFgContactGroupsMyInvite(IFgContactGroupsMyInvitedView iFgContactGroupsMyInvitedView) {
        this.iFgContactGroupsMyInvitedView = iFgContactGroupsMyInvitedView;
    }
}