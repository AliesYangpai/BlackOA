package com.blackcoffee.work.ui.adapter;

import com.blackcoffee.work.R;
import com.blackcoffee.work.test.TestWork;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作的child 客戶Adapter
 * 版本
 */
public class WorkChildClientAdapter extends BaseQuickAdapter<TestWork, BaseViewHolder> {


    public WorkChildClientAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper, TestWork item) {
        helper.setText(R.id.tv_work_client_title,item.getTitle())
                .setText(R.id.tv_work_client_info_name1,item.getName())
                .setText(R.id.tv_work_client_info_name2,item.getName())
                .setText(R.id.tv_work_client_info,item.getDescrib())
                .setText(R.id.tv_client_time,item.getTime());




    }
}