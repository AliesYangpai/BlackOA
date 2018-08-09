package com.blackcoffee.work.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterContactPhoneDetail;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IContactPhoneDetialView;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 手机联系人类表详情
 */
public class ContactPhoneDetailActivity extends BaseActivity<IContactPhoneDetialView, PresenterContactPhoneDetail> implements
        IContactPhoneDetialView,
        OnClickListener {


    private PresenterContactPhoneDetail presenterContactPhoneDetail;


    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    /**
     * center
     *
     * @param savedInstanceState
     */


    private CircleImageView civ_user_head;
    private TextView tv_name;
    private TextView tv_phone;
    private TextView tv_greet_text;
    private TextView tv_bottom;


    /**
     * 数据相关
     *
     * @param savedInstanceState
     */
    private SelfContact selfContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_phone_detail);
        doInitTestData();
    }

    private void doInitTestData() {

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.img_contact_bg);


        FunctionText functionText = new FunctionText();
        String target = functionText.getTargetName(selfContact.getContactName());
        ImgUtil.getInstance().getImgFromNetByUrl(selfContact.getAvatuar(), civ_user_head, new DrawableInText(target, 30, bitmap));


        tv_name.setText(selfContact.getContactName());
        tv_phone.setText(selfContact.getContactNo());
        tv_greet_text.setText("我是" + "西安黑咖啡网络科技有限公司的" + "Slim Shady");
    }

    @Override
    protected PresenterContactPhoneDetail creatPresenter() {
        if (null == presenterContactPhoneDetail) {
            presenterContactPhoneDetail = new PresenterContactPhoneDetail(this);
        }

        return presenterContactPhoneDetail;
    }

    @Override
    protected void initViews() {
        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.detail);


        /**
         * center
         *
         * @param savedInstanceState
         */


        civ_user_head = findOAViewById(R.id.civ_user_head);
        tv_name = findOAViewById(R.id.tv_name);
        tv_phone = findOAViewById(R.id.tv_phone);
        tv_greet_text = findOAViewById(R.id.tv_greet_text);
        tv_bottom = findOAViewById(R.id.tv_bottom);
    }

    @Override
    protected void initListener() {

        iv_common_back.setOnClickListener(this);
        tv_bottom.setOnClickListener(this);

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

            case R.id.tv_bottom:
                ToastUtil.showMsg(getApplicationContext(), "发送添加请求");
                break;
        }
    }
}
