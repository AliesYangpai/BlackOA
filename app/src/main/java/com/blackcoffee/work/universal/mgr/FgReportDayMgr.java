package com.blackcoffee.work.universal.mgr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.blackcoffee.work.R;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyCreate;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyInvited;
import com.blackcoffee.work.ui.fragment.FragmentReportDayScan;
import com.blackcoffee.work.ui.fragment.FragmentReportDayWrite;
import com.blackcoffee.work.universal.logic.view.LogicViewFg;

import org.feezu.liuli.timeselector.Utils.TextUtil;

/**
 * Created by admin on 2018/5/9.
 * 类描述 我的群组界面 相关的fg管理类
 * 版本
 */
public class FgReportDayMgr {
    /**
     * fragment相关
     */
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private String currentFgTag; //记录当前栈顶的fragment的Tag
    private LogicViewFg logicViewFg;

    public FgReportDayMgr() {
    }

    public FgReportDayMgr(FragmentManager fragmentManager, FragmentTransaction transaction) {
        this.fragmentManager = fragmentManager;
        this.transaction = transaction;
        this.logicViewFg = new LogicViewFg();
    }


    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public FragmentTransaction getTransaction() {
        return transaction;
    }

    public String getCurrentFgTag() {
        return currentFgTag;
    }

    /**
     * 根据不同FragmnetTag来得到不同fragment实例
     *
     * @param fgTag
     */
    public void getDifferentFragment(String fgTag) {


        Fragment fragment = fragmentManager.findFragmentByTag(fgTag); //通过id找到fragment
        transaction = fragmentManager.beginTransaction();

        if (null == fragment) {

            if (fgTag.equals(FragmentReportDayWrite.TAG)) {
                //我创建的
                fragment = new FragmentReportDayWrite();

            }

            if (fgTag.equals(FragmentReportDayScan.TAG)) {
                //我创建的
                fragment = new FragmentReportDayScan();

            }

            Log.i("fragmentTest", "==============实例化的fragment：" + fgTag);

            Fragment currentTopFragment = fragmentManager.findFragmentByTag(currentFgTag); //得到当前栈顶部的fragmnet

            if (null != currentTopFragment) {


                Log.i("fragmentTest", "当前栈顶的fragment：---->" + currentFgTag + " 被隐藏掉" + "  新的栈顶fragment：" + fgTag);

                transaction.hide(currentTopFragment).add(R.id.fragment_container_report_day, fragment, fgTag).commit();  //如果存在则让其隐藏【解决创建后隐藏问题】
                currentFgTag = fgTag;


            } else {


                Log.i("fragmentTest", "当前栈顶没有fragment！！！！！！！！，将" + fgTag + " 设置到栈顶");

                transaction.add(R.id.fragment_container_report_day, fragment, fgTag).commit();

                currentFgTag = fgTag;


            }

        } else {


            Fragment currentFragment = fragmentManager.findFragmentByTag(currentFgTag);


            if (currentFgTag.equals(fgTag)) {

                Log.i("fragmentTest", fgTag + " ***********选中它，并且已经被实例化了,但是与currentFgTag相等，执行return");


                return;
            }


            Log.i("fragmentTest", fgTag + " ***********选中它，并且已经被实例化了" + " 当前栈顶的fragment：" + currentFgTag + "被隐藏掉");


            switchFragment(currentFragment, fragment);


            currentFgTag = fgTag;


        }


    }


    /**
     * 根据postion对应的fragment
     *
     * @param position
     */
    public void getDifferentFragmentByPosition(int position) {

        String fgTag = logicViewFg.getFgReportTagByPosition(position);

        if (!TextUtil.isEmpty(fgTag)) {

            getDifferentFragment(fgTag);
        }


    }


    /**
     * fragment隐藏切换
     *
     * @param from
     * @param to
     */
    public void switchFragment(Fragment from, Fragment to) {
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fragment_container_report_day, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }
}