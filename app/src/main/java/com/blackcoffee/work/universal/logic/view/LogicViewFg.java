package com.blackcoffee.work.universal.logic.view;

import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.fragment.FragmentApp;
import com.blackcoffee.work.ui.fragment.FragmentChatMsg;
import com.blackcoffee.work.ui.fragment.FragmentConnect;
import com.blackcoffee.work.ui.fragment.FragmentReportDayScan;
import com.blackcoffee.work.ui.fragment.FragmentReportDayWrite;
import com.blackcoffee.work.ui.fragment.FragmentUser;
import com.blackcoffee.work.ui.fragment.FragmentWork;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildAll;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildAnnounce;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildApprove;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildClient;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildReport;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyCreate;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyInvited;

/**
 * Created by admin on 2018/5/9.
 * 类描述  根据View的position获取对应的fragment
 * 版本
 */
public class LogicViewFg {


    /**
     * main界面中对应的点击选择项
     * @param position
     * @return
     */
    public String getFgMainTagByPosition(int position) {

        String fgTag = null;
        switch (position) {

            case 0:
                fgTag = FragmentChatMsg.TAG;
                break;

            case 1:
                fgTag = FragmentConnect.TAG;
                break;

            case 2:
                fgTag = FragmentWork.TAG;
                break;

            case 3:
                fgTag = FragmentApp.TAG;
                break;

            case 4:
                fgTag = FragmentUser.TAG;
                break;
        }

        return fgTag;
    }


    /**
     *  工作界面中对应的点击选择项
     * @param position
     * @return
     */
    public String getFgWorkTagByPosition(int position) {

        String fgTag = null;
        switch (position) {

            case 0:
                fgTag = FragmentWorkChildAll.TAG;
                break;

            case 1:
                fgTag = FragmentWorkChildApprove.TAG;
                break;

            case 2:
                fgTag = FragmentWorkChildReport.TAG;
                break;

            case 3:
                fgTag = FragmentWorkChildClient.TAG;
                break;

            case 4:
                fgTag = FragmentWorkChildAnnounce.TAG;
                break;
        }

        return fgTag;
    }



    /**
     *  群组界面中对应的点击选择项
     * @param position
     * @return
     */
    public String getFgContactGroupTagByPosition(int position) {

        String fgTag = null;
        switch (position) {

            case 0:
                fgTag = FragmentContactGroupsMyCreate.TAG;
                break;

            case 1:
                fgTag = FragmentContactGroupsMyInvited.TAG;
                break;

        }

        return fgTag;
    }




    /**
     *  群组界面中对应的点击选择项
     * @param position
     * @return
     */
    public String getFgReportTagByPosition(int position) {

        String fgTag = null;
        switch (position) {

            case 0:
                fgTag = FragmentReportDayWrite.TAG;
                break;

            case 1:
                fgTag = FragmentReportDayScan.TAG;
                break;

        }

        return fgTag;
    }

}