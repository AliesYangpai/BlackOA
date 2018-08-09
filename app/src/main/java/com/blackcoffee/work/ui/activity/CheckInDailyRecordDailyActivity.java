package com.blackcoffee.work.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAChildViewClickListener;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAItemClickListener;
import com.blackcoffee.work.constant.ConstHz;
import com.blackcoffee.work.constant.ConstSign;
import com.blackcoffee.work.presenter.PresenterCheckInRecordDaily;
import com.blackcoffee.work.test.TestCheckIn;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.adapter.CheckInRecordDailyAdapter;
import com.blackcoffee.work.ui.iview.ICheckInRecordDailyView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

public class CheckInDailyRecordDailyActivity extends BaseActivity<ICheckInRecordDailyView, PresenterCheckInRecordDaily> implements
        ICheckInRecordDailyView,
        View.OnClickListener,
        com.haibin.calendarview.CalendarView.OnDateSelectedListener,
        OnBlackOAItemClickListener,
        OnBlackOAChildViewClickListener {


    private PresenterCheckInRecordDaily presenterCheckInRecordDaily;


    /**
     * title
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private CircleImageView civ_user_head;
    private TextView tv_user_name;
    private TextView tv_date;
    private TextView tv_week_date;


    private TextView tv_year_month;
    private CalendarLayout cl_calendar_layout;
    private CalendarView cv_calendar;


    private RecyclerView rv_list;
    private CheckInRecordDailyAdapter checkInRecordDailyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_record_daily);
        doInitTestData();

    }


    private void doInitTestData() {

        FunctionText functionText = new FunctionText();
        String targetName = functionText.getTargetName("王富贵");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_contact_bg);
        ImgUtil.getInstance().getImgFromNetByUrl("", civ_user_head, new DrawableInText(targetName, 30, bitmap));
        tv_user_name.setText("王富贵");
        tv_date.setText(cv_calendar.getCurYear() + ConstSign.POINT + cv_calendar.getCurMonth() + ConstSign.POINT + cv_calendar.getCurDay());
        tv_week_date.setText("星期三");
        tv_year_month.setText(cv_calendar.getCurYear() + ConstHz.YEAR + cv_calendar.getCurMonth() + ConstHz.MONTH);
        checkInRecordDailyAdapter.setList(TestContent.getTestCheckInAll());
    }

    @Override
    protected PresenterCheckInRecordDaily creatPresenter() {
        if (null == presenterCheckInRecordDaily) {
            presenterCheckInRecordDaily = new PresenterCheckInRecordDaily(this);
        }

        return presenterCheckInRecordDaily;
    }

    @Override
    protected void initViews() {
        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.check_in_record);

        civ_user_head = findOAViewById(R.id.civ_user_head);
        tv_user_name = findOAViewById(R.id.tv_user_name);
        tv_date = findOAViewById(R.id.tv_date);
        tv_week_date = findOAViewById(R.id.tv_week_date);


        tv_year_month = findOAViewById(R.id.tv_year_month);
        cl_calendar_layout = findOAViewById(R.id.cl_calendar_layout);
        cv_calendar = findOAViewById(R.id.cv_calendar);



        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        checkInRecordDailyAdapter = new CheckInRecordDailyAdapter();
        rv_list.setAdapter(checkInRecordDailyAdapter);
    }

    @Override
    protected void initListener() {

        iv_common_back.setOnClickListener(this);


        checkInRecordDailyAdapter.setOnBlackOAItemClickListener(this);
        checkInRecordDailyAdapter.setOnBlackOAChildViewClickListener(this);

        cv_calendar.setOnDateSelectedListener(this);


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
        }
    }


    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        tv_year_month.setText(calendar.getYear() + ConstHz.YEAR + calendar.getMonth() + ConstHz.MONTH);
    }

    @Override
    public void onItemClick(String tag,View view, int position, Object o) {
        TestCheckIn testCheckIn = (TestCheckIn) o;
        ToastUtil.showMsg(getApplicationContext(),"列表点击项"+testCheckIn.getCheckTime());
    }

    @Override
    public void onChildClick(String tag, View view, Object o) {
        TestCheckIn testCheckIn = (TestCheckIn) o;
        ToastUtil.showMsg(getApplicationContext(),"申请补卡"+testCheckIn.getCheckTime());

        openActivity(CheckInRemedyActivity.class,null);
    }
}
