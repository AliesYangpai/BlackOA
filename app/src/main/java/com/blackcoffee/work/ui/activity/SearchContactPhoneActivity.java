package com.blackcoffee.work.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstSQL;
import com.blackcoffee.work.constant.ConstSign;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.presenter.PresenterSearchContactPhone;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.adapter.forlistview.SearchContactPhoneAdapter;
import com.blackcoffee.work.ui.iview.ISearchContactPhoneView;
import com.blackcoffee.work.util.ToastUtil;

import org.litepal.crud.DataSupport;

import java.util.List;

public class SearchContactPhoneActivity extends BaseActivity<ISearchContactPhoneView, PresenterSearchContactPhone> implements
        ISearchContactPhoneView,
        View.OnClickListener,
        TextWatcher,
        AdapterView.OnItemClickListener {


    private PresenterSearchContactPhone presenterSearchContactPhone;


    /**
     * title
     *
     * @param savedInstanceState
     */
    private ImageView iv_common_back;
    private EditText et_search;

    private ListView lv;
    private SearchContactPhoneAdapter searchContactPhoneAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact_phone);
    }

    @Override
    protected PresenterSearchContactPhone creatPresenter() {

        if (null == presenterSearchContactPhone) {
            presenterSearchContactPhone = new PresenterSearchContactPhone(this);
        }

        return presenterSearchContactPhone;
    }

    @Override
    protected void initViews() {
        /**
         * title
         * @param savedInstanceState
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        et_search = findOAViewById(R.id.et_search);

        lv = findOAViewById(R.id.lv);
        searchContactPhoneAdapter = new SearchContactPhoneAdapter(this);
        lv.setAdapter(searchContactPhoneAdapter);
    }

    @Override
    protected void initListener() {
        /**
         * title
         */
        iv_common_back.setOnClickListener(this);
        et_search.addTextChangedListener(this);

        lv.setOnItemClickListener(this);

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
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String arg = editable.toString();

        Log.i("textwatech", "============" + arg);


//        presenterSearchContactPhone.doSearch(arg,
//                ConstSQL.SelfContact.FUZZY_CONTACT_NAME + ConstSQL.OR +
//                        ConstSQL.SelfContact.FUZZY_CONTACT_PHONE_NO + ConstSQL.OR +
//                        ConstSQL.SelfContact.FUZZY_CONTACT_PINYIN,
//                ConstSign.PERCENT + arg + ConstSign.PERCENT,
//                ConstSign.PERCENT + arg + ConstSign.PERCENT,
//                ConstSign.PERCENT + arg + ConstSign.PERCENT
//
//        );


        presenterSearchContactPhone.doSearch(arg,
                ConstSQL.SelfContact.FUZZY_CONTACT_NAME + ConstSQL.OR +
                        ConstSQL.SelfContact.FUZZY_CONTACT_PHONE_NO + ConstSQL.OR +
                        ConstSQL.SelfContact.FUZZY_CONTACT_PINYIN + ConstSQL.OR +
                        ConstSQL.SelfContact.FUZZY_CONTACT_SHORT_PINYIN,
                ConstSign.PERCENT + arg + ConstSign.PERCENT,
                arg + ConstSign.PERCENT,
                ConstSign.PERCENT + arg + ConstSign.PERCENT,
                ConstSign.PERCENT + arg + ConstSign.PERCENT
        );


//        presenterSearchContactPhone.doSearch(arg,
//                ConstSQL.SelfContact.DIM_CONTACT_NAME, ConstSign.PERCENT+arg+ConstSign.PERCENT,
//
//                        ConstSQL.SelfContact.DIM_CONTACT_PHONE_NO,ConstSign.PERCENT+arg+ConstSign.PERCENT,
//
//                        ConstSQL.SelfContact.DIM_CONTACT_PINYIN,ConstSign.PERCENT+arg+ConstSign.PERCENT
//                );
    }


    @Override
    public void onDataBackSuccessForContactPhoneSearch(List<SelfContact> selfContacts) {
        searchContactPhoneAdapter.setList(selfContacts);
    }

    @Override
    public void doSearchRecordsClear() {
        searchContactPhoneAdapter.setList(null);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        SelfContact selfContact = (SelfContact) searchContactPhoneAdapter.getItem(i);
        Bundle bundle = new Bundle();
        bundle.putSerializable(TestContent.TEST_BUNDLE_KEY, selfContact);
        openActivity(ContactPhoneDetailActivity.class, bundle);
    }
}
