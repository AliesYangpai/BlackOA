package com.blackcoffee.work.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blackcoffee.work.ui.iview.IMainView;
import com.blackcoffee.work.universal.mgr.FgMainMgr;

/**
 * Created by admin on 2018/5/9.
 * 类描述  主页的presenter
 * 版本
 */
public class PresenterMain extends BasePresenter<IMainView> {

    private IMainView iMainView;


    private FgMainMgr fgMainMgr;

    public PresenterMain(IMainView iMainView,FragmentManager fragmentManager, FragmentTransaction transaction) {
        this.iMainView = iMainView;
        this.fgMainMgr = new FgMainMgr(fragmentManager,transaction);
    }


    /**
     * 获取不同的fragment
     * @param fgTag
     */
    public void doGetDifferentFragment(String fgTag) {
        fgMainMgr.getDifferentFragment(fgTag);
    }


    /**
     * 根据fragment的position获取对应的fragment
     * @param position
     */
    public void doGetDifferentFragmentByPosition(int position) {

        fgMainMgr.getDifferentFragmentByPosition(position);
    }








}