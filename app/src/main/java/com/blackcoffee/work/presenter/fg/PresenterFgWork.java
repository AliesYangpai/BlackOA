package com.blackcoffee.work.presenter.fg;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgWorkView;
import com.blackcoffee.work.universal.mgr.FgMainMgr;
import com.blackcoffee.work.universal.mgr.FgWorkMgr;

/**
 * Created by admin on 2018/5/22.
 * 类描述
 * 版本
 */
public class PresenterFgWork extends BasePresenter<IFgWorkView> {

    private IFgWorkView iFgWorkView;
    private FgWorkMgr fgWorkMgr;


    public PresenterFgWork(IFgWorkView iFgWorkView, FragmentManager fragmentManager, FragmentTransaction transaction) {
        this.iFgWorkView = iFgWorkView;
        this.fgWorkMgr = new FgWorkMgr(fragmentManager,transaction);
    }

    /**
     * 获取不同的fragment
     * @param fgTag
     */
    public void doGetDifferentFragment(String fgTag) {
        fgWorkMgr.getDifferentFragment(fgTag);
    }


    /**
     * 根据fragment的position获取对应的fragment
     * @param position
     */
    public void doGetDifferentFragmentByPosition(int position) {

        fgWorkMgr.getDifferentFragmentByPosition(position);
    }

    
}