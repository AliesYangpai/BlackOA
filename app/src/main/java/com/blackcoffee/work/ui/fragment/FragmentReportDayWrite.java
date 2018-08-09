package com.blackcoffee.work.ui.fragment;


import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAChildViewClickListener;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAItemClickListener;
import com.blackcoffee.work.constant.ConstIntent;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.presenter.fg.PresenterFgReportDayWrite;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.GoodsActivity;
import com.blackcoffee.work.ui.activity.WorkApproveDetialActivity;
import com.blackcoffee.work.ui.adapter.AddApproverAdapter;
import com.blackcoffee.work.ui.adapter.AddCopyToAdapter;
import com.blackcoffee.work.ui.adapter.AddFileAdapter;
import com.blackcoffee.work.ui.iview.fg.IFgReportDayWriteView;
import com.blackcoffee.work.util.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * 写日报的fragment
 */
public class FragmentReportDayWrite extends BaseFragment<IFgReportDayWriteView, PresenterFgReportDayWrite> implements
        IFgReportDayWriteView,
        View.OnClickListener,
        OnBlackOAChildViewClickListener,
        OnBlackOAItemClickListener,
        PermissionListener {
    public static final String TAG = FragmentReportDayWrite.class.getSimpleName();

    private PresenterFgReportDayWrite presenterFgReportDayWrite;


    private EditText et_finished_work;
    private EditText et_unfinished_work;
    private EditText et_needs_work;
    private EditText et_remark;


    private RecyclerView rl_list_files;
    private AddFileAdapter addFileAdapter;
    private RecyclerView rl_list_approver;
    private AddApproverAdapter addApproverAdapter;
    private RecyclerView rl_list_copy_to;
    private AddCopyToAdapter addCopyToAdapter;


    private TextView tv_commit;

    @Override
    protected PresenterFgReportDayWrite creatPresenter() {

        if (null == presenterFgReportDayWrite) {

            presenterFgReportDayWrite = new PresenterFgReportDayWrite(this);
        }

        return presenterFgReportDayWrite;

    }

    @Override
    protected int setLayoutResouceId() {

        return R.layout.fragment_report_day_write;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {


        et_finished_work = findOAViewById(R.id.et_finished_work);
        et_unfinished_work = findOAViewById(R.id.et_unfinished_work);
        et_needs_work = findOAViewById(R.id.et_needs_work);
        et_remark = findOAViewById(R.id.et_remark);


        rl_list_files = findOAViewById(R.id.rl_list_files);
        addFileAdapter = new AddFileAdapter();
        rl_list_files.setLayoutManager(new GridLayoutManager(mActivity, ConstLocalData.DEFUALT_DYNAMIC_OPERATE_SINGLE_COUNT));
        rl_list_files.setAdapter(addFileAdapter);


        rl_list_approver = findOAViewById(R.id.rl_list_approver);
        addApproverAdapter = new AddApproverAdapter();
        rl_list_approver.setLayoutManager(new GridLayoutManager(mActivity, ConstLocalData.DEFUALT_DYNAMIC_OPERATE_SINGLE_COUNT));
        rl_list_approver.setAdapter(addApproverAdapter);


        rl_list_copy_to = findOAViewById(R.id.rl_list_copy_to);
        addCopyToAdapter = new AddCopyToAdapter();
        rl_list_copy_to.setLayoutManager(new GridLayoutManager(mActivity, ConstLocalData.DEFUALT_DYNAMIC_OPERATE_SINGLE_COUNT));
        rl_list_copy_to.setAdapter(addCopyToAdapter);


        tv_commit = findOAViewById(R.id.tv_commit);
    }

    @Override
    protected void initListener() {





        addFileAdapter.setOnBlackOAChildViewClickListener(this);
        addFileAdapter.setOnBlackOAItemClickListener(this);


        addApproverAdapter.setOnBlackOAChildViewClickListener(this);
        addApproverAdapter.setOnBlackOAItemClickListener(this);

        addCopyToAdapter.setOnBlackOAChildViewClickListener(this);
        addCopyToAdapter.setOnBlackOAItemClickListener(this);


        tv_commit.setOnClickListener(this);
    }

    @Override
    protected void onLazyLoad() {
        addFileAdapter.setList(TestContent.getTestFileAdd());
        addApproverAdapter.setList(TestContent.getTestFileAdd());
        addCopyToAdapter.setList(TestContent.getTestFileAdd());
    }

    @Override
    protected void onEventBack(EventEntity eventEntity) {

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
        ToastUtil.showMsg(mActivity.getApplicationContext(), errorMsg);
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
                        AndPermission.rationaleDialog(mActivity, rationale).show();
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
    public void onUploadStart(int what) {

    }

    @Override
    public void onUploadCancel(int what) {

    }

    @Override
    public void onUploadProgress(int what, int progress) {

    }

    @Override
    public void onUploadFinish(int what) {

    }

    @Override
    public void onUploadError(int what, Exception exception) {

    }

    @Override
    public void onDataBackSuccessForUpload(String path) {

    }

    @Override
    public void doIsAddFile() {

        presenterFgReportDayWrite.doPermissionCheck(
                ConstIntent.RequestCode.APPLY_FOR_PERMISSION_UPLOAD,
                Manifest.permission.CAMERA);

    }

    @Override
    public void doIsAddApprover() {
        List<FileAdd> fileAdds = addApproverAdapter.getList();
        fileAdds.add(0, new FileAdd(TestContent.headUrl1, ConstLocalData.DEL));
        addApproverAdapter.setList(fileAdds);
    }

    @Override
    public void doIsAddCopyTo() {
        List<FileAdd> fileAdds = addCopyToAdapter.getList();
        fileAdds.add(0, new FileAdd(TestContent.headUrl1, ConstLocalData.DEL));
        addCopyToAdapter.setList(fileAdds);
    }

    @Override
    public void doIsDelFile(FileAdd fileAdd) {

        List<FileAdd> fileAdds = addFileAdapter.getList();
        fileAdds.remove(fileAdd);
        addFileAdapter.setList(fileAdds);
    }

    @Override
    public void doIsDelApprover(FileAdd fileAdd) {
        List<FileAdd> fileAdds = addApproverAdapter.getList();
        fileAdds.remove(fileAdd);
        addApproverAdapter.setList(fileAdds);
    }

    @Override
    public void doIsDelCopyTo(FileAdd fileAdd) {
        List<FileAdd> fileAdds = addCopyToAdapter.getList();
        fileAdds.remove(fileAdd);
        addCopyToAdapter.setList(fileAdds);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.tv_commit:


                Bundle bundle = new Bundle();
                bundle.putSerializable(TestContent.TEST_BUNDLE_KEY, TestContent.getTestWorkSingleTakeBreak());
                openActivity(WorkApproveDetialActivity.class, bundle);
                break;


        }
    }

    @Override
    public void onItemClick(String adapterTag, View view, int position, Object o) {

    }

    @Override
    public void onChildClick(String adapterTag, View view, Object o) {
        presenterFgReportDayWrite.doDealItemChildClick(adapterTag, o);
    }

    @Override
    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
        switch (requestCode) {

            case ConstIntent.RequestCode.APPLY_FOR_PERMISSION_UPLOAD:


                /**
                 * 调用上传那图片
                 */

                ToastUtil.showMsg(mActivity.getApplicationContext(), "调用上传图片");

                List<FileAdd> fileAdds = addFileAdapter.getList();
                fileAdds.add(0, new FileAdd(TestContent.headUrl1, ConstLocalData.DEL));

                addFileAdapter.setList(fileAdds);

                break;
        }
    }

    @Override
    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
        switch (requestCode) {

            case ConstIntent.RequestCode.APPLY_FOR_PERMISSION_UPLOAD:
                presenterFgReportDayWrite.doShowPermissionDialog();
                break;
        }
    }
}
