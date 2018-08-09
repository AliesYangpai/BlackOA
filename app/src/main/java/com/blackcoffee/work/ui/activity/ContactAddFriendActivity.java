package com.blackcoffee.work.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstIntent;
import com.blackcoffee.work.presenter.PresenterContactAddFriend;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IContactAddFriendView;
import com.blackcoffee.work.util.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

public class ContactAddFriendActivity extends BaseActivity<IContactAddFriendView,PresenterContactAddFriend> implements
        IContactAddFriendView,
        View.OnClickListener,
        PermissionListener {


    private PresenterContactAddFriend presenterContactAddFriend;

    /**
     * title
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private LinearLayout ll_phone_search;
    private LinearLayout ll_swipe_scan;
    private LinearLayout ll_add_to_phone_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add_friend);
    }

    @Override
    protected PresenterContactAddFriend creatPresenter() {
        if(null == presenterContactAddFriend) {
            presenterContactAddFriend= new PresenterContactAddFriend(this);
        }

        return presenterContactAddFriend;
    }

    @Override
    protected void initViews() {
        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.add);


        ll_phone_search = findOAViewById(R.id.ll_phone_search);
        ll_swipe_scan = findOAViewById(R.id.ll_swipe_scan);
        ll_add_to_phone_contact = findOAViewById(R.id.ll_add_to_phone_contact);
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);

        ll_phone_search.setOnClickListener(this);
        ll_swipe_scan.setOnClickListener(this);
        ll_add_to_phone_contact.setOnClickListener(this);
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
        ToastUtil.showMsg(getApplicationContext(),errorMsg);
    }

    @Override
    public void doPermissionCheck(int requestCode, String... permissions) {
        AndPermission
                .with(this)
                .requestCode(requestCode)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {
                        AndPermission.rationaleDialog(ContactAddFriendActivity.this, rationale).show();
                    }
                })
                .callback(this)
                .start();
    }

    @Override
    public void doShowPermissionDialog() {
        AndPermission.defaultSettingDialog(this, ConstIntent.RequestCode.SYSYEM_SETTING)
                .setTitle(this.getString(R.string.permission_title))
                .setMessage(this.getString(R.string.permission_msg))
                .setPositiveButton(this.getString(R.string.permission_sure))
                .setNegativeButton(this.getString(R.string.permission_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    @Override
    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {



        /**
         * 申请权限全部允许之前不会回调该方法
         */
        Log.i("quanxianxxxx", "onSucceed " + requestCode + "   ");
        switch (requestCode) {
            case ConstIntent.RequestCode.APPLY_FOR_PERMISSION_SWEEP:

                openActivity(QRScanAddContactActivity.class,null);

                break;

        }
    }

    @Override
    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {

        presenterContactAddFriend.doShowPermissionDialog();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_common_back:
                dofinishItself();
                break;


            case R.id.ll_phone_search:


                openActivity(SearchPhoneNoActivity.class, null);
                break;

            case R.id.ll_swipe_scan:



                presenterContactAddFriend.doPermissionCheck(
                        ConstIntent.RequestCode.APPLY_FOR_PERMISSION_SWEEP,
                        Manifest.permission.CAMERA,
                        Manifest.permission.VIBRATE);
                break;

            case R.id.ll_add_to_phone_contact:
                ToastUtil.showMsg(getApplicationContext(), "添加来自手机通讯录");

                openActivity(ContactPhonesActivity.class,null);
                break;

        }
    }
}
