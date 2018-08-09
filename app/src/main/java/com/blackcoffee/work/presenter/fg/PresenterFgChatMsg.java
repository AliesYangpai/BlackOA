package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgChatMsgView;

/**
 * Created by admin on 2018/5/9.
 * 类描述 消息fragment的界面管理者
 * 版本
 */
public class PresenterFgChatMsg extends BasePresenter<IFgChatMsgView> {

    private IFgChatMsgView iFgChatMsgView;


    public PresenterFgChatMsg(IFgChatMsgView iFgChatMsgView) {
        this.iFgChatMsgView = iFgChatMsgView;
    }


}