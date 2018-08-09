package com.blackcoffee.work.presenter.fg.child;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildAll;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildApprove;

/**
 * Created by admin on 2018/5/27.
 * 类描述  审批的presenter
 * 版本
 */
public class PresenterFgWorkChildApprove extends BasePresenter<IFgWorkChildApprove> {

    private IFgWorkChildApprove iFgWorkChildApprove;


    public PresenterFgWorkChildApprove(IFgWorkChildApprove iFgWorkChildApprove) {
        this.iFgWorkChildApprove = iFgWorkChildApprove;
    }


}