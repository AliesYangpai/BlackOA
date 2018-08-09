package com.blackcoffee.work.ui.widget.popwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.PopWindowLayoutItemClickCallBack;
import com.blackcoffee.work.callback.popwindow.OnPopwindowDownDismissCallBack;
import com.blackcoffee.work.entity.temp.ReportDay;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.adapter.forlistview.PopReportSelectAdapter;
import com.blackcoffee.work.util.ToastUtil;

import java.util.List;

/**
 * Created by admin on 2018/6/8.
 * 类描述
 * 版本
 */
public class PopWindowLayout extends RelativeLayout implements
        View.OnClickListener,
        OnPopwindowDownDismissCallBack,
        AdapterView.OnItemClickListener {


    private Context mContext;
    private RelativeLayout rl_pop_title_center;
    private TextView tv_common_title;
    private ImageView iv_top_down_arrow;







    /**
     * 内容物 popwindowde的相关布局
     */
    private PopWindowDown popWindowDown;
    private LinearLayout content;
    private ListView lv;
    private PopReportSelectAdapter popReportSelectAdapter;


    /**
     * 数据相关
     */
    private List<ReportDay> reportDayList;
    private ReportDay currentReportDay;











    private PopWindowLayoutItemClickCallBack popWindowLayoutItemClickCallBack;


    public void setPopWindowLayoutItemClickCallBack(PopWindowLayoutItemClickCallBack popWindowLayoutItemClickCallBack) {
        this.popWindowLayoutItemClickCallBack = popWindowLayoutItemClickCallBack;
    }

    public PopWindowLayout(Context context) {
        super(context);
    }

    public PopWindowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopWindowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initListener();
    }


    private void initView(Context context) {
        mContext = context;


        /**
         * 这个按钮的菜单布局
         */
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_pop_title_center, this, true);
        rl_pop_title_center = (RelativeLayout) view.findViewById(R.id.rl_pop_title_center);
        tv_common_title = (TextView) view.findViewById(R.id.tv_common_title);
        iv_top_down_arrow = (ImageView) view.findViewById(R.id.iv_top_down_arrow);


        //点击事件，点击外部区域隐藏popupWindow


        /**
         * 内容物 popwindowde的相关布局
         */


        View view1 = LayoutInflater.from(mContext).inflate(R.layout.popwindow_report_select, null);
        content = (LinearLayout)view1.findViewById(R.id.content);
        lv = (ListView) view1.findViewById(R.id.lv);
        popReportSelectAdapter = new PopReportSelectAdapter(mContext);
        lv.setAdapter(popReportSelectAdapter);
        popWindowDown = new PopWindowDown(mContext, view1, this);
        popWindowDown.setOnPopwindowDownDismissCallBack(this);



    }


    /**
     * 初始化监听
     */

    private void initListener() {
        rl_pop_title_center.setOnClickListener(this);
        content.setOnClickListener(this);
        lv.setOnItemClickListener(this);
    }


    public void doSetData(List<ReportDay> reportDayList) {

        this.reportDayList = reportDayList;
        currentReportDay = this.reportDayList.get(0);

        tv_common_title.setText(currentReportDay.getTypeName());
        iv_top_down_arrow.setImageResource(R.drawable.img_blue_arrow_dir_down);
        popReportSelectAdapter.setList(this.reportDayList, currentReportDay.getType());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.rl_pop_title_center:
                popWindowDown.show();
                iv_top_down_arrow.setImageResource(R.drawable.img_blue_arrow_dir_up);
                break;


            case R.id.content:
                popWindowDown.hide();
                break;

        }
    }


    @Override
    public void onPopWindowDownDismiss() {
        iv_top_down_arrow.setImageResource(R.drawable.img_blue_arrow_dir_down);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ReportDay reportDay = (ReportDay) popReportSelectAdapter.getItem(i);
        currentReportDay = reportDay;
        tv_common_title.setText(reportDay.getTypeName());
        popReportSelectAdapter.setCurrentTag(currentReportDay.getType());


        switch (reportDay.getType()) {

            case 0:


                if(null != popWindowLayoutItemClickCallBack) {
                    popWindowLayoutItemClickCallBack.onClickItemWrite();
                }

                break;

            case 1:

                if(null != popWindowLayoutItemClickCallBack) {
                    popWindowLayoutItemClickCallBack.onClickItemScan();
                }

                break;
        }

        popWindowDown.hide();

    }
}