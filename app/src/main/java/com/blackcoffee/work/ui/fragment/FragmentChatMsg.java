package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;
import android.widget.TextView;

import com.blackcoffee.work.App;
import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgChatMsg;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.fg.IFgChatMsgView;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 消息fragment
 */
public class FragmentChatMsg extends BaseFragment<IFgChatMsgView,PresenterFgChatMsg> implements IFgChatMsgView {

    public static final String TAG = FragmentChatMsg.class.getSimpleName();
    private PresenterFgChatMsg presenterFgChatMsg;



    /**
     * title
     */
    private TextView tv_common_title;


    @Override
    protected PresenterFgChatMsg creatPresenter() {

        if(null == presenterFgChatMsg) {

            presenterFgChatMsg = new PresenterFgChatMsg(this);
        }
        return presenterFgChatMsg;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_chat_msg;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {

          tv_common_title = findOAViewById(R.id.tv_common_title);
          tv_common_title.setText(R.string.msg);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected void onEventBack(EventEntity eventEntity) {

    }

    @Override
    public void showLoadingDialog() {

        showLoadDialog();
    }

    @Override
    public void dismissLoadingDialog() {
        dismissLoadDialog();
    }

    @Override
    public void onDataBackFail(int code, String errorMsg) {
        ToastUtil.showMsg(App.getInstance().getApplicationContext(),errorMsg);
    }
}
