package com.blackcoffee.work.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterCheckIn;
import com.blackcoffee.work.test.TestCheckIn;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.ICheckInView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;

import java.util.List;

public class CheckInActivity extends BaseActivity<ICheckInView, PresenterCheckIn> implements
        ICheckInView,
        View.OnClickListener,
        Chronometer.OnChronometerTickListener {


    private PresenterCheckIn presenterCheckIn;

    /**
     * title
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;
    private TextView tv_right;


    /**
     * 头像相关
     */
    private CircleImageView civ_user_head;
    private TextView tv_user_name;
    private TextView tv_date;
    private TextView tv_week_date;


    /**
     * 左侧timeLine 相关
     */
    private ImageView iv_time_line_start;
    private View v_time_line;
    private ImageView iv_time_line_end;


    /**
     * 右1 上班打卡信息相关
     */
    private TextView tv_morning_stipulate_time_1;
    private TextView tv_check_time_1;
    private TextView tv_check_status1;
    private TextView tv_location_1;
    private LinearLayout ll_update_check_1;


    /**
     * 右2 下班打卡信息相关
     */
    private TextView tv_morning_stipulate_time_2;
    private TextView tv_check_time_2;
    private TextView tv_check_status_2;
    private TextView tv_location_2;
    private LinearLayout ll_update_check_2;


    /**
     * 下面打卡相关
     */
    private LinearLayout ll_do_check_in;
    private Chronometer ch_time;


    /**
     * 底部的定位地址
     */
    private LinearLayout ll_bottom_location;
    private TextView tv_current_range;


    /*****************计时器*******************/

    int count = 86380;


    public String FormatMiss(int miss) {
        String hh = miss / 3600 > 9 ? miss / 3600 + "" : "0" + miss / 3600;
        String mm = (miss % 3600) / 60 > 9 ? (miss % 3600) / 60 + "" : "0" + (miss % 3600) / 60;
        String ss = (miss % 3600) % 60 > 9 ? (miss % 3600) % 60 + "" : "0" + (miss % 3600) % 60;
        return hh + ":" + mm + ":" + ss;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        doInitTestData();
    }


    private void doInitTestData() {
        List<TestCheckIn> testCheckIns = TestContent.getTestCheckInAll();


        TestCheckIn testCheckIn0 = testCheckIns.get(0);
        TestCheckIn testCheckIn1 = testCheckIns.get(1);

        FunctionText functionText = new FunctionText();
        String targetName = functionText.getTargetName("王富贵");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_contact_bg);

        ImgUtil.getInstance().getImgFromNetByUrl("", civ_user_head, new DrawableInText(targetName, 30, bitmap));
        /**
         * 头像相关
         */
        tv_user_name.setText("王富贵");
        tv_date.setText("2018.06.05");
        tv_week_date.setText("星期二");


        /**
         * 左侧timeLine 相关
         */
        iv_time_line_start.setImageResource(R.drawable.img_check_time_line_blue);
        iv_time_line_end.setImageResource(R.drawable.img_check_time_line_blue);


        /**
         * 右1 上班打卡信息相关
         */
        tv_morning_stipulate_time_1.setText("上班时间：" + testCheckIn0.getWorkTime());
        tv_check_time_1.setText("打卡时间：" + testCheckIn0.getCheckTime());
        tv_check_status1.setText("正常");
        tv_check_status1.setBackgroundResource(R.drawable.boder_bg_green_radius_2);
        tv_location_1.setText(testCheckIn0.getLocation());



        /**
         * 右2 下班打卡信息相关
         */
        tv_morning_stipulate_time_2.setText("下班时间：" + testCheckIn1.getWorkTime());
        tv_check_time_2.setText("打卡时间：" + testCheckIn1.getCheckTime());

        tv_check_status_2.setText("正常");
        tv_check_status_2.setBackgroundResource(R.drawable.boder_bg_green_radius_2);
        tv_location_2.setText(testCheckIn1.getLocation());


        /**
         * 下面打卡相关
         */


        ch_time.setFormat(FormatMiss(count));
        ch_time.start();


        /**
         * 底部的定位地址
         */

        tv_current_range.setText(testCheckIn0.getLocation());


    }

    @Override
    protected PresenterCheckIn creatPresenter() {

        if (null == presenterCheckIn) {
            presenterCheckIn = new PresenterCheckIn(this);
        }

        return presenterCheckIn;
    }

    @Override
    protected void initViews() {
        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.check_in);
        tv_right = findOAViewById(R.id.tv_right);
        tv_right.setText(R.string.check_in_record);


        /**
         * 头像相关
         */
        civ_user_head = findOAViewById(R.id.civ_user_head);
        tv_user_name = findOAViewById(R.id.tv_user_name);
        tv_date = findOAViewById(R.id.tv_date);
        tv_week_date = findOAViewById(R.id.tv_week_date);


        /**
         * 左侧timeLine 相关
         */
        iv_time_line_start = findOAViewById(R.id.iv_time_line_start);
        v_time_line = findOAViewById(R.id.v_time_line);
        iv_time_line_end = findOAViewById(R.id.iv_time_line_end);


        /**
         * 右1 上班打卡信息相关
         */
        tv_morning_stipulate_time_1 = findOAViewById(R.id.tv_morning_stipulate_time_1);
        tv_check_time_1 = findOAViewById(R.id.tv_check_time_1);
        tv_check_status1 = findOAViewById(R.id.tv_check_status_1);
        tv_location_1 = findOAViewById(R.id.tv_location_1);
        ll_update_check_1 = findOAViewById(R.id.ll_update_check_1);


        /**
         * 右2 下班打卡信息相关
         */
        tv_morning_stipulate_time_2 = findOAViewById(R.id.tv_morning_stipulate_time_2);
        tv_check_time_2 = findOAViewById(R.id.tv_check_time_2);
        tv_check_status_2 = findOAViewById(R.id.tv_check_status_2);
        tv_location_2 = findOAViewById(R.id.tv_location_2);
        ll_update_check_2 = findOAViewById(R.id.ll_update_check_2);


        /**
         * 下面打卡相关
         */
        ch_time = findOAViewById(R.id.ch_time);
        ll_do_check_in = findOAViewById(R.id.ll_do_check_in);


        /**
         * 底部的定位地址
         */
        ll_bottom_location = findOAViewById(R.id.ll_bottom_location);
        tv_current_range = findOAViewById(R.id.tv_current_range);


    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);

        tv_right.setOnClickListener(this);
        ch_time.setOnChronometerTickListener(this);


        ll_update_check_1.setOnClickListener(this);
        ll_update_check_2.setOnClickListener(this);


        ll_do_check_in.setOnClickListener(this);



    }

    @Override
    protected void processIntent() {

    }

    @Override
    public void showLoadingDialog() {
        showLoadDialog();
    }

    @Override
    public void dismissLoadingDialog() {
        dismissLoadDialog();
    }

    @Override
    public void onDataBackFail(int code, String errorMsg) {
        ToastUtil.showMsg(getApplicationContext(), errorMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_common_back:
                dofinishItself();
                break;


            case R.id.tv_right:


                openActivity(CheckInDailyRecordDailyActivity.class,null);
                break;

            case R.id.ll_do_check_in:
                ToastUtil.showMsg(getApplicationContext(),"打卡");
                break;

            case R.id.ll_update_check_1:
                ToastUtil.showMsg(getApplicationContext(),"上班打卡更新");

                break;

            case R.id.ll_update_check_2:
                ToastUtil.showMsg(getApplicationContext(),"下班打卡更新");
                break;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {

        if (count == 86400) {

            count = 0;

        }
        count++;

        Log.i("ssswws", count + " ");

        chronometer.setFormat(FormatMiss(count));
    }
}
