package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.blackcoffee.work.App;
import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgConnect;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.ContactAddActivity;
import com.blackcoffee.work.ui.activity.ContactFriendsActivity;
import com.blackcoffee.work.ui.activity.ContactGroupsActivity;
import com.blackcoffee.work.ui.activity.ContactPhonesActivity;
import com.blackcoffee.work.ui.adapter.forlistview.TopContactAdapter;
import com.blackcoffee.work.ui.iview.fg.IFgConnectView;
import com.blackcoffee.work.ui.widget.listview.ChildListView;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 联系人fragment
 */
public class FragmentConnect extends BaseFragment<IFgConnectView, PresenterFgConnect> implements IFgConnectView,
        View.OnClickListener{

    public static final String TAG = FragmentConnect.class.getSimpleName();
    private PresenterFgConnect presenterFgConnect;



    /**
     * title
     */
    private TextView tv_common_title;
    private ImageView iv_right;


    private ScrollView sv_contact;
    private LinearLayout ll_search;
    private LinearLayout ll_phone_contact;
    private LinearLayout ll_my_friends;
    private LinearLayout ll_my_group;
    private LinearLayout ll_department_structure;


    /**
     * listView相关
     */
    private ChildListView clv_top_contact;
    private TopContactAdapter topContactAdapter;


    @Override
    protected PresenterFgConnect creatPresenter() {
        if (presenterFgConnect == null) {

            presenterFgConnect = new PresenterFgConnect(this);
        }

        return presenterFgConnect;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_connect;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {


        /**
         * title
         */
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.connect);
        iv_right = findOAViewById(R.id.iv_right);
        iv_right.setImageResource(R.drawable.img_add_friends);

        sv_contact = findOAViewById(R.id.sv_contact);
        ll_search = findOAViewById(R.id.ll_search);
        ll_phone_contact = findOAViewById(R.id.ll_phone_contact);
        ll_my_friends = findOAViewById(R.id.ll_my_friends);
        ll_my_group = findOAViewById(R.id.ll_my_group);
        ll_department_structure = findOAViewById(R.id.ll_department_structure);

        clv_top_contact = findOAViewById(R.id.clv_top_contact);
        topContactAdapter = new TopContactAdapter(getContext());
        clv_top_contact.setAdapter(topContactAdapter);
    }

    @Override
    protected void initListener() {
        iv_right.setOnClickListener(this);
        ll_search.setOnClickListener(this);
        ll_phone_contact.setOnClickListener(this);
        ll_my_friends.setOnClickListener(this);
        ll_my_group.setOnClickListener(this);
        ll_department_structure.setOnClickListener(this);

    }

    @Override
    protected void onLazyLoad() {
        topContactAdapter.setList(TestContent.getTestContacts());
        tv_common_title.setFocusable(true);
        tv_common_title.setFocusableInTouchMode(true);
        tv_common_title.requestFocus();

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
        ToastUtil.showMsg(App.getInstance().getApplicationContext(), errorMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.iv_right:

                openActivity(ContactAddActivity.class,null);
                break;

            case R.id.ll_search:
                ToastUtil.showMsg(getContext(),"进入搜索界面");
                break;

            case R.id.ll_phone_contact:

                openActivity(ContactPhonesActivity.class,null);


                break;

            case R.id.ll_my_friends:
                openActivity(ContactFriendsActivity.class,null);
                break;


            case R.id.ll_my_group:

                openActivity(ContactGroupsActivity.class,null);
                break;

            case R.id.ll_department_structure:
                ToastUtil.showMsg(getContext(),"进入部门架构界面");
                break;
        }
    }





}
