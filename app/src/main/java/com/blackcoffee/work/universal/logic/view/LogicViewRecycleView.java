package com.blackcoffee.work.universal.logic.view;

import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.fragment.FragmentApp;
import com.blackcoffee.work.ui.fragment.FragmentChatMsg;
import com.blackcoffee.work.ui.fragment.FragmentConnect;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyCreate;
import com.blackcoffee.work.ui.fragment.FragmentContactGroupsMyInvited;
import com.blackcoffee.work.ui.fragment.FragmentUser;
import com.blackcoffee.work.ui.fragment.FragmentWork;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildAll;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildAnnounce;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildApprove;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildClient;
import com.blackcoffee.work.ui.fragment.child.FragmentWorkChildReport;

/**
 * Created by admin on 2018/5/9.
 * 类描述  recycleView的逻辑
 * 版本
 */
public class LogicViewRecycleView {




    /**
     * 类表中 添加上传文件的逻辑判断n
     * @param
     * @return
     */
    public boolean isOperateAdd(String  tag) {


        boolean result = false;

        switch (tag) {

            case ConstLocalData.ADD:
                result = true;
                break;

            case ConstLocalData.DEL:
                result = false;
                break;
        }

        return result;
    }
}