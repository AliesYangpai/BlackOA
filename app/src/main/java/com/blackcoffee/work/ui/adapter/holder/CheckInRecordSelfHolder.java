package com.blackcoffee.work.ui.adapter.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alorma.timeline.RoundTimelineView;
import com.blackcoffee.work.R;
import com.blackcoffee.work.ui.BaseSelfViewHolder;

import java.util.concurrent.TimeoutException;

/**
 * Created by admin on 2018/6/5.
 * 类描述 打卡记录中 日历底部adapter 所在的holder
 * 版本
 */
public class CheckInRecordSelfHolder extends BaseSelfViewHolder {

    public TextView tv_check_in_time;
    public TextView tv_check_status;
    public TextView tv_check_in_remedy;
    public TextView tv_stander_work_time;

    public CheckInRecordSelfHolder(View itemView) {
        super(itemView);


        tv_check_in_time = findOAViewById(R.id.tv_check_in_time);
        tv_stander_work_time = findOAViewById(R.id.tv_stander_work_time);
        tv_check_status = findOAViewById(R.id.tv_check_status);
        tv_check_in_remedy = findOAViewById(R.id.tv_check_in_remedy);

    }


}