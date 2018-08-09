package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.iview.ICheckInRecordDailyView;

/**
 * Created by admin on 2018/6/6.
 * 类描述  打卡记录的presenter
 * 版本
 */
public class PresenterCheckInRecordDaily extends BasePresenter<ICheckInRecordDailyView> {

    private ICheckInRecordDailyView iCheckInRecordDailyView;

    public PresenterCheckInRecordDaily(ICheckInRecordDailyView iCheckInRecordDailyView) {
        this.iCheckInRecordDailyView = iCheckInRecordDailyView;
    }
}