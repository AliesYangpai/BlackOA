package com.blackcoffee.work.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterContactFriends;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.adapter.ContactFriendsAdapter;
import com.blackcoffee.work.ui.iview.IContactFriendsView;
import com.blackcoffee.work.util.ToastUtil;

import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;

public class ContactFriendsActivity extends BaseActivity<IContactFriendsView,PresenterContactFriends> implements
        IContactFriendsView,
        View.OnClickListener,
        IndexableAdapter.OnItemContentClickListener {


    private PresenterContactFriends presenterContactFriends;


    /**
     * titlle
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;
    private TextView tv_right;
    private LinearLayout ll_search;


    private ContactFriendsAdapter contactFriendsAdapter;
    private IndexableLayout indexableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_friends);
        presenterContactFriends.doGetSelfContactFromDb();
    }

    @Override
    protected PresenterContactFriends creatPresenter() {
        if(null == presenterContactFriends) {
            presenterContactFriends = new PresenterContactFriends(this);
        }
        return presenterContactFriends;
    }

    @Override
    protected void initViews() {
        /**
         * titlle
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.my_friends);
        tv_right = findOAViewById(R.id.tv_right);
        tv_right.setText(R.string.add_friends);
        ll_search = findOAViewById(R.id.ll_search);




        indexableLayout = findOAViewById(R.id.indexableLayout);
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
        contactFriendsAdapter = new ContactFriendsAdapter(this);
        indexableLayout.setAdapter(contactFriendsAdapter);
        indexableLayout.setOverlayStyle_Center();
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);
    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        ll_search.setOnClickListener(this);

        contactFriendsAdapter.setOnItemContentClickListener(this);
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
    public void dismissFreshLoading() {

    }

    @Override
    public void onDataBackFailInLoadMore(int code, String errorMsg) {

    }

    @Override
    public void onDataBackSuccessForGetFriends(List<TestApplicationMySection> testApplicationMySections) {

    }



    @Override
    public void doShowSelfContactFromDb(List<SelfContact> selfContacts) {
        contactFriendsAdapter.setDatas(selfContacts);


        for (SelfContact selfContact : selfContacts) {

            Log.i("contactSS", selfContact.getContactName() + " 头像：" + selfContact.getAvatuar()+" 拼音："+selfContact.getPinYin()+" 字母缩写："+selfContact.getShortPinYin());
        }
    }

    @Override
    public void onVertifyErrorNoContacts() {
        ToastUtil.showMsg(getApplicationContext(), getString(R.string.error_no_contacts));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_common_back:
                dofinishItself();
                break;


            case R.id.tv_right:

                openActivity(ContactAddFriendActivity.class,null);
                break;


            case R.id.ll_search:
                ToastUtil.showMsg(getApplicationContext(), "进入到搜索界面");
                break;
        }
    }

    @Override
    public void onItemClick(View v, int originalPosition, int currentPosition, Object entity) {
        SelfContact selfContact = (SelfContact) entity;



        Bundle bundle = new Bundle();
        bundle.putSerializable(TestContent.TEST_BUNDLE_KEY,selfContact);
        openActivity(ContactFriendDetailActivity.class,bundle);
    }
}
