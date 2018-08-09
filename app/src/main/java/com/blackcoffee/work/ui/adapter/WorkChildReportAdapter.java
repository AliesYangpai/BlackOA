package com.blackcoffee.work.ui.adapter;

import com.blackcoffee.work.R;
import com.blackcoffee.work.test.TestWork;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作的child 汇报Adapter
 * 版本
 */
public class WorkChildReportAdapter extends BaseQuickAdapter<TestWork, BaseViewHolder> {


    public WorkChildReportAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper, TestWork item) {




        helper.setText(R.id.tv_work_report_title,item.getTitle())
                .setText(R.id.tv_work_report_info_title,item.getName())
                .setText(R.id.tv_work_report_info_title,item.getName())
                .setText(R.id.tv_work_report_info,item.getDescrib())
                .setText(R.id.tv_report_time,item.getTime());




    }
}