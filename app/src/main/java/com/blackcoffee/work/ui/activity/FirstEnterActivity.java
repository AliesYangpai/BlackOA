package com.blackcoffee.work.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;

import com.blackcoffee.work.R;
import com.blackcoffee.work.androidelement.provider.ContactProvider;
import com.blackcoffee.work.constant.ConstIntent;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterFirstEnter;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IFirstEnterView;
import com.blackcoffee.work.util.ToastUtil;
import com.yanzhenjie.nohttp.rest.StringRequest;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import org.litepal.crud.DataSupport;

import java.util.List;

public class FirstEnterActivity extends BaseActivity<IFirstEnterView, PresenterFirstEnter> implements
        IFirstEnterView,
        PermissionListener {


    private PresenterFirstEnter presenterFirstEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenterFirstEnter.doPermissionCheck(ConstIntent.RequestCode.APPLY_FOR_PERMISSION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_COARSE_LOCATION);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case ConstIntent.RequestCode.SYSYEM_SETTING:


                if (AndPermission.hasPermission(FirstEnterActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    presenterFirstEnter.doGoToMainOrWelCome();

                } else {


                    presenterFirstEnter.doShowPermissionDialog();

                }

                Log.i("quanxianxxxx", "onActivityResult " + requestCode + "   ");


                break;

        }
    }

    @Override
    protected PresenterFirstEnter creatPresenter() {
        presenterFirstEnter = new PresenterFirstEnter(this);
        return presenterFirstEnter;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processIntent() {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void onDataBackFail(int code, String errorMsg) {
        ToastUtil.showMsg(getApplicationContext(), errorMsg);
    }

//    @Override
//    public void doPermissionCheck() {
//        AndPermission
//                .with(this)
//                .requestCode(ConstIntent.RequestCode.APPLY_FOR_PERMISSION)
//                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_PHONE_STATE,
//                        Manifest.permission.ACCESS_COARSE_LOCATION
//                )
//                .rationale(new RationaleListener() {
//                    @Override
//                    public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {
//
//
//                        AndPermission.rationaleDialog(FirstEnterActivity.this, rationale).show();
//
//                    }
//                })
//                .callback(this)
//                .start();
//    }

    @Override
    public void doPermissionCheck(int requestCode, String... permissions) {
        AndPermission
                .with(this)
                .requestCode(requestCode)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {


                        AndPermission.rationaleDialog(FirstEnterActivity.this, rationale).show();

                    }
                })
                .callback(this)
                .start();
    }

    @Override
    public void doShowPermissionDialog() {

        AndPermission.defaultSettingDialog(FirstEnterActivity.this, ConstIntent.RequestCode.SYSYEM_SETTING)
                .setTitle(FirstEnterActivity.this.getString(R.string.permission_title))
                .setMessage(FirstEnterActivity.this.getString(R.string.permission_msg))
                .setPositiveButton(FirstEnterActivity.this.getString(R.string.permission_sure))
                .setNegativeButton(FirstEnterActivity.this.getString(R.string.permission_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirstEnterActivity.this.finish();
                    }
                })
                .show();

    }

    @Override
    public void doGoToWelcome() {
        openActivityAndFinishItself(WelcomeActivity.class, null);
    }

    @Override
    public void doGoToMain() {

        openActivityAndFinishItself(MainActivity.class, null);
    }

    @Override
    public void doGetPhoneConTact() {

        List<SelfContact> selfContacts = new ContactProvider(this).doGetPhoneContacts();
        presenterFirstEnter.doSaveContact(selfContacts);
        presenterFirstEnter.doGoToMainOrWelCome();
    }

    @Override
    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {

        /**
         * 申请权限全部允许之前不会回调该方法
         */
        Log.i("quanxianxxxx", "onSucceed " + requestCode + "   ");
        switch (requestCode) {
            case ConstIntent.RequestCode.APPLY_FOR_PERMISSION:


                presenterFirstEnter.doGetContact();


//                presenterFirstEnter.doGoToMainOrWelCome();


                break;

        }
    }

    @Override
    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
        Log.i("quanxianxxxx", "onFailed " + requestCode + "   ");
        switch (requestCode) {
            case ConstIntent.RequestCode.APPLY_FOR_PERMISSION:

                // 第一种：用AndPermission默认的提示语。
                presenterFirstEnter.doShowPermissionDialog();

                break;

        }
    }
}
