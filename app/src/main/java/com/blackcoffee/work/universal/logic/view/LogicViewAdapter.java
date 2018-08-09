package com.blackcoffee.work.universal.logic.view;

import com.blackcoffee.work.ui.adapter.AddApproverAdapter;
import com.blackcoffee.work.ui.adapter.AddCopyToAdapter;
import com.blackcoffee.work.ui.adapter.AddFileAdapter;

/**
 * Created by admin on 2018/6/7.
 * 类描述  adapter的相关逻辑类型
 * 版本
 */
public class LogicViewAdapter {


    public boolean isAddFilesAdapter(String tag) {
        return tag.equals(AddFileAdapter.Tag);
    }


    public boolean isAddApproverAdapter(String tag) {
        return tag.equals(AddApproverAdapter.Tag);
    }


    public boolean isAddCopyToAdapter(String tag) {
        return tag.equals(AddCopyToAdapter.Tag);
    }
}