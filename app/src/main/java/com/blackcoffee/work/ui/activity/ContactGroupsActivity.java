package com.blackcoffee.work.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.presenter.PresenterContactGroups;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IContactGroupsView;
import com.blackcoffee.work.util.ToastUtil;

public class ContactGroupsActivity extends BaseActivity<IContactGroupsView,PresenterContactGroups> implements
        IContactGroupsView,
        View.OnClickListener,
        TabLayout.OnTabSelectedListener{


    private PresenterContactGroups presenterContactGroups;

    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;
    private TextView tv_right;
    private LinearLayout ll_search;


    /**
     * 中间
     * @param savedInstanceState
     */


    private TabLayout tl_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_groups);


        tl_group.getTabAt(ConstLocalData.TAB_INDEX_0).select();
    }

    @Override
    protected PresenterContactGroups creatPresenter() {
        if(null == presenterContactGroups) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            presenterContactGroups = new PresenterContactGroups(this,fragmentManager,fragmentManager.beginTransaction());
        }

        return presenterContactGroups;
    }

    @Override
    protected void initViews() {
        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.my_group);
        tv_right = findOAViewById(R.id.tv_right);
        tv_right.setText(R.string.start_group_chart);
        ll_search = findOAViewById(R.id.ll_search);


        /**
         * 中间
         */

        tl_group = findOAViewById(R.id.tl_group);


        /**
         * 这里需要注意下，当我们添加table的时候，就会直接调用addOnTabSelectedListener
         * 所以addOnTabSelectedListener 要写在addTab前面
         */
        tl_group.addOnTabSelectedListener(this);
        tl_group.addTab(tl_group.newTab().setText(R.string.group_my_create));
        tl_group.addTab(tl_group.newTab().setText(R.string.group_my_invited));

    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        ll_search.setOnClickListener(this);




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
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_common_back:
                dofinishItself();
                break;


            case R.id.tv_right:

                ToastUtil.showMsg(getApplicationContext(), "发起群聊");
                break;


            case R.id.ll_search:
                ToastUtil.showMsg(getApplicationContext(), "进入到搜索界面");
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        Log.i("select_Tab", " 选中" + tab.getText());

        presenterContactGroups.doGetDifferentFragmentByPosition(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
