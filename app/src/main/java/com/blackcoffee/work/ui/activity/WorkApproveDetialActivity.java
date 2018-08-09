package com.blackcoffee.work.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterWorkApproveDetail;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IWorkApproveDetailView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;

public class WorkApproveDetialActivity extends BaseActivity<IWorkApproveDetailView, PresenterWorkApproveDetail> implements
        IWorkApproveDetailView,
        View.OnClickListener {

    private PresenterWorkApproveDetail presenterWorkApproveDetail;


    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    /**
     * 上
     */
    private CircleImageView civ_approver_head_top;
    private TextView tv_approver_name_top;
    private TextView tv_statue_top;
    private ImageView iv_approve_statue;

    /**
     * 中
     */
    private TextView tv_key_1;
    private TextView tv_value_1;
    private TextView tv_key_2;
    private TextView tv_value_2;
    private TextView tv_key_3;
    private TextView tv_value_3;
    private TextView tv_key_4;
    private TextView tv_value_4;
    private TextView tv_key_5;
    private TextView tv_value_5;


    /**
     * 下
     */
    private CircleImageView civ_my_head;
    private TextView tv_my_send;
    private TextView tv_send_time;


    private CircleImageView civ_approver_head_bottom;
    private TextView tv_approver_name_bottom;
    private TextView tv_statue;
    private TextView tv_approve_time;


    /**
     * 数据相关
     *
     * @param savedInstanceState
     */

    private TestWork testWork;

    private void doInitData() {


        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_contact_bg);
        ImgUtil.getInstance().getImgFromNetByUrl("", civ_approver_head_top, new DrawableInText("富贵", 30, bitmap));

        tv_approver_name_top.setText(testWork.getName());
        tv_statue_top.setText("审核通过");


        iv_approve_statue.setImageResource(R.drawable.test_img_access);

        tv_key_1.setText("出差地点");
        tv_value_1.setText("上海");
        tv_key_2.setText("开始时间");
        tv_value_2.setText("2017-05-07 08:00");
        tv_key_3.setText("结束时间");
        tv_value_3.setText("2017-06-07 19:00");
        tv_key_4.setText("时长（天）");
        tv_value_4.setText("30");

        tv_key_5.setText("出差事由");
        tv_value_5.setText("本月前往上海，1.负责展销会的举办，并总结经验；2.与其他企业巨头进行更深的商业浅谈；3.对上海分公司的运作状况进行初步的了解");


        ImgUtil.getInstance().getImgFromNetByUrl("", civ_my_head, new DrawableInText("我", 30, bitmap));
        tv_my_send.setText("我" + " " + "发起申请");
        tv_send_time.setText("2017-05-05 08:00");


        ImgUtil.getInstance().getImgFromNetByUrl("", civ_approver_head_bottom, new DrawableInText("富贵", 30, bitmap));
        tv_approver_name_bottom.setText(testWork.getName());
        tv_statue.setText("已同意");
        tv_approve_time.setText("2017-05-06 08:00");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_approve_detial);

        doInitData();
    }

    @Override
    protected PresenterWorkApproveDetail creatPresenter() {

        if (null == presenterWorkApproveDetail) {

            presenterWorkApproveDetail = new PresenterWorkApproveDetail(this);
        }

        return presenterWorkApproveDetail;
    }

    @Override
    protected void initViews() {

        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(testWork.getDescribTitle());


        /**
         * 上
         */
        civ_approver_head_top = findOAViewById(R.id.civ_approver_head_top);
        tv_approver_name_top = findOAViewById(R.id.tv_approver_name_top);
        tv_statue_top = findOAViewById(R.id.tv_statue_top);
        iv_approve_statue = findOAViewById(R.id.iv_approve_statue);


        /**
         * 中
         */
        tv_key_1 = findOAViewById(R.id.tv_key_1);
        tv_value_1 = findOAViewById(R.id.tv_value_1);
        tv_key_2 = findOAViewById(R.id.tv_key_2);
        tv_value_2 = findOAViewById(R.id.tv_value_2);
        tv_key_3 = findOAViewById(R.id.tv_key_3);
        tv_value_3 = findOAViewById(R.id.tv_value_3);
        tv_key_4 = findOAViewById(R.id.tv_key_4);
        tv_value_4 = findOAViewById(R.id.tv_value_4);
        tv_key_5 = findOAViewById(R.id.tv_key_5);
        tv_value_5 = findOAViewById(R.id.tv_value_5);


        /**
         * 下
         */
        civ_my_head = findOAViewById(R.id.civ_my_head);
        tv_my_send = findOAViewById(R.id.tv_my_send);
        tv_send_time = findOAViewById(R.id.tv_send_time);


        civ_approver_head_bottom = findOAViewById(R.id.civ_approver_head_bottom);
        tv_approver_name_bottom = findOAViewById(R.id.tv_approver_name_bottom);
        tv_statue = findOAViewById(R.id.tv_statue);
        tv_approve_time = findOAViewById(R.id.tv_approve_time);
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
    }

    @Override
    protected void processIntent() {

        Intent intent = this.getIntent();
        if (null != intent) {
            Bundle bundle = intent.getExtras();

            if (null != bundle) {
                testWork = (TestWork) bundle.getSerializable(TestContent.TEST_BUNDLE_KEY);
            }
        }

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
}
