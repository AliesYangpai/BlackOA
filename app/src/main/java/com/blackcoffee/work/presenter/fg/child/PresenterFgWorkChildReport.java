package com.blackcoffee.work.presenter.fg.child;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildApprove;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildReport;

/**
 * Created by admin on 2018/5/27.
 * 类描述  汇报的presenter
 * 版本
 */
public class PresenterFgWorkChildReport extends BasePresenter<IFgWorkChildReport> {

    private IFgWorkChildReport iFgWorkChildReport;


    public PresenterFgWorkChildReport(IFgWorkChildReport iFgWorkChildReport) {
        this.iFgWorkChildReport = iFgWorkChildReport;
    }


}