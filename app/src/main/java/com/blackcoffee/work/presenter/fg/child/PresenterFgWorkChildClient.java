package com.blackcoffee.work.presenter.fg.child;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildClient;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildReport;

/**
 * Created by admin on 2018/5/27.
 * 类描述  客户的presenter
 * 版本
 */
public class PresenterFgWorkChildClient extends BasePresenter<IFgWorkChildClient> {

    private IFgWorkChildClient iFgWorkChildClient;


    public PresenterFgWorkChildClient(IFgWorkChildClient iFgWorkChildClient) {
        this.iFgWorkChildClient = iFgWorkChildClient;
    }


}