package com.blackcoffee.work.ui.adapter;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ListView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAChildViewClickListener;
import com.blackcoffee.work.test.TestCheckIn;
import com.blackcoffee.work.ui.BaseSelfAdapter;
import com.blackcoffee.work.ui.adapter.holder.CheckInRecordSelfHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/6.
 * 类描述
 * 版本
 */
public class CheckInRecordDailyAdapter extends BaseSelfAdapter<CheckInRecordSelfHolder> {


    public static final String Tag = CheckInRecordDailyAdapter.class.getSimpleName();

    private List<TestCheckIn> list;


    public void setList(List<TestCheckIn> list) {

        if (null == list) {
            list = new ArrayList<>();
        }
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    protected CheckInRecordSelfHolder onBlackOACreateViewHolder(View inflate) {

        CheckInRecordSelfHolder checkInRecordSelfHolder = new CheckInRecordSelfHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onBlackOAItemClickListener) {

                    Integer position = (Integer) view.getTag();

                    onBlackOAItemClickListener.onItemClick(Tag,view, position, list.get(position));
                }
            }
        });

        return checkInRecordSelfHolder;

    }

    @Override
    protected void onBlackOABindViewHolder(CheckInRecordSelfHolder checkInRecordSelfHolder, int position) {


        final TestCheckIn testCheckIn = list.get(position);


        checkInRecordSelfHolder.tv_check_in_time.setText("上班时间："+testCheckIn.getCheckTime());
        checkInRecordSelfHolder.tv_check_status.setText(testCheckIn.getStatus());
        checkInRecordSelfHolder.tv_stander_work_time.setText("上班时间："+testCheckIn.getWorkTime());
        checkInRecordSelfHolder.tv_check_in_remedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onBlackOAChildViewClickListener) {

                    onBlackOAChildViewClickListener.onChildClick(Tag,view, testCheckIn);
                }
            }
        });


    }

    @Override
    protected int layoutId() {
        return R.layout.item_check_in_record_self_holder;
    }

    @Override
    protected int getBlackOAItemCount() {
        if (null != list && list.size() > 0) {
            return list.size();
        }

        return 0;
    }
}