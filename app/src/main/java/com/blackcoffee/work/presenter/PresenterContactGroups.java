package com.blackcoffee.work.presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blackcoffee.work.ui.iview.IContactGroupsView;
import com.blackcoffee.work.universal.mgr.FgContactGroupMgr;

/**
 * Created by admin on 2018/6/1.
 * 类描述
 * 版本
 */
public class PresenterContactGroups extends BasePresenter<IContactGroupsView> {

    private IContactGroupsView iContactGroupsView;

    private FgContactGroupMgr fgContactGroupMgr;

    public PresenterContactGroups(IContactGroupsView iContactGroupsView,FragmentManager fragmentManager, FragmentTransaction transaction) {
        this.iContactGroupsView = iContactGroupsView;
        this.fgContactGroupMgr = new FgContactGroupMgr(fragmentManager, transaction);
    }



    /**
     * 获取不同的fragment
     * @param fgTag
     */
    public void doGetDifferentFragment(String fgTag) {
        fgContactGroupMgr.getDifferentFragment(fgTag);
    }


    /**
     * 根据fragment的position获取对应的fragment
     * @param position
     */
    public void doGetDifferentFragmentByPosition(int position) {

        fgContactGroupMgr.getDifferentFragmentByPosition(position);
    }
}