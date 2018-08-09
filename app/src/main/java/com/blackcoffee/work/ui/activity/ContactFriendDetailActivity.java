package com.blackcoffee.work.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.constant.ConstSign;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterContactFriendDetail;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IContactFriendDetialView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.SimCardUtil;
import com.blackcoffee.work.util.ToastUtil;

public class ContactFriendDetailActivity extends BaseActivity<IContactFriendDetialView, PresenterContactFriendDetail> implements
        IContactFriendDetialView,
        View.OnClickListener {


    private PresenterContactFriendDetail presenterContactFriendDetail;

    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private CircleImageView civ_user_head;
    private TextView tv_name;
    private ImageView iv_qr_icon;
    private TextView tv_enterprise_name;
    private TextView tv_certificate_state;
    private TextView tv_phone;
    private TextView tv_email;

    private LinearLayout ll_left;
    private LinearLayout ll_right;


    /**
     * 数据相关
     *
     * @param savedInstanceState
     */
    private SelfContact selfContact;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_friend_detail);

        doInitTestData();
    }



    private void doInitTestData() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_contact_bg);


        FunctionText functionText = new FunctionText();
        String target = functionText.getTargetName(selfContact.getContactName());
        ImgUtil.getInstance().getImgFromNetByUrl(selfContact.getAvatuar(), civ_user_head, new DrawableInText(target, 30, bitmap));


        tv_name.setText(selfContact.getContactName());

        tv_enterprise_name.setText("西安黑咖啡网络科技有限公司");
        tv_certificate_state.setText("已认证");
        tv_phone.setText(selfContact.getContactNo());

        tv_email.setText(selfContact.getShortPinYin()+"@BCtalk.com");



    }

    @Override
    protected PresenterContactFriendDetail creatPresenter() {

        if (null == presenterContactFriendDetail) {
            presenterContactFriendDetail = new PresenterContactFriendDetail(this);
        }

        return presenterContactFriendDetail;
    }

    @Override
    protected void initViews() {
        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.personal_info);


        civ_user_head = findOAViewById(R.id.civ_user_head);
        tv_name = findOAViewById(R.id.tv_name);
        iv_qr_icon = findOAViewById(R.id.iv_qr_icon);
        tv_enterprise_name = findOAViewById(R.id.tv_enterprise_name);
        tv_certificate_state = findOAViewById(R.id.tv_certificate_state);
        tv_phone = findOAViewById(R.id.tv_phone);
        tv_email = findOAViewById(R.id.tv_email);

        ll_left = findOAViewById(R.id.ll_left);
        ll_right = findOAViewById(R.id.ll_right);
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
        iv_qr_icon.setOnClickListener(this);
        ll_left.setOnClickListener(this);
        ll_right.setOnClickListener(this);

    }

    @Override
    protected void processIntent() {

        Intent intent = this.getIntent();
        if (null != intent) {
            Bundle bundle = intent.getExtras();

            if (null != bundle) {

                selfContact = (SelfContact) bundle.getSerializable(TestContent.TEST_BUNDLE_KEY);
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


            case R.id.iv_qr_icon:


                Bundle bundle = new Bundle();
                bundle.putSerializable(TestContent.TEST_BUNDLE_KEY,selfContact);
                openActivity(QRCodeIdentifyCardActivity.class,bundle);
                break;

            case R.id.ll_left:
                break;

            case R.id.ll_right:

                presenterContactFriendDetail.doDealCall(selfContact.getContactNo());
                break;
        }
    }

    @Override
    public void onVertifyErrorForNoPhoneNum() {
        ToastUtil.showMsg(getApplicationContext(), R.string.have_not_get_contact);
    }

    @Override
    public void onVertifyErrorForNoSimCard() {
        ToastUtil.showMsg(getApplicationContext(), R.string.not_sim_card);
    }

    @Override
    public void doGetTeleManager(String phone) {
        TelephonyManager telMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telMgr.getSimState();

        presenterContactFriendDetail.doDealCallContinue(simState,phone);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void doCall(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(ConstLocalData.TEL+ ConstSign.COLON + phone));
        startActivity(intent);
    }



}
