package com.blackcoffee.work.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.IMainView;
import com.blackcoffee.work.ui.iview.IReportDayView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;
import com.blackcoffee.work.universal.mgr.FgMainMgr;
import com.blackcoffee.work.universal.mgr.FgReportDayMgr;

/**
 * Created by admin on 2018/5/29.
 * 类描述  日报presenter
 * 版本
 */
public class PresenterReportDay extends BasePresenter<IReportDayView> {



    private FgReportDayMgr fgReportDayMgr;
    private IReportDayView iReportDayView;

    public PresenterReportDay(IReportDayView iReportDayView, FragmentManager fragmentManager, FragmentTransaction transaction) {
        this.iReportDayView = iReportDayView;
        this.fgReportDayMgr = new FgReportDayMgr(fragmentManager,transaction);
    }



    /**
     * 获取不同的fragment
     * @param fgTag
     */
    public void doGetDifferentFragment(String fgTag) {
        fgReportDayMgr.getDifferentFragment(fgTag);
    }


    /**
     * 根据fragment的position获取对应的fragment
     * @param position
     */
    public void doGetDifferentFragmentByPosition(int position) {

        fgReportDayMgr.getDifferentFragmentByPosition(position);
    }



}