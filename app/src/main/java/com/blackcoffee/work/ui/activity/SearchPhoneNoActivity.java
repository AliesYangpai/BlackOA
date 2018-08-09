package com.blackcoffee.work.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterSearchPhoneNo;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.ISearchPhoneNoView;

public class SearchPhoneNoActivity extends BaseActivity<ISearchPhoneNoView,PresenterSearchPhoneNo> implements
        ISearchPhoneNoView,
        View.OnClickListener,
        TextWatcher{


    private PresenterSearchPhoneNo presenterSearchPhoneNo;

    /**
     * title
     * @param savedInstanceState
     */
    private ImageView iv_common_back;
    private EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_phone_no);
    }

    @Override
    protected PresenterSearchPhoneNo creatPresenter() {

        if(null == presenterSearchPhoneNo) {
            presenterSearchPhoneNo = new PresenterSearchPhoneNo(this);
        }

        return presenterSearchPhoneNo;
    }

    @Override
    protected void initViews() {
        /**
         * title
         * @param savedInstanceState
         */
          iv_common_back = findOAViewById(R.id.iv_common_back);
          et_search = findOAViewById(R.id.et_search);
    }

    @Override
    protected void initListener() {
        /**
         * title
         */
        iv_common_back.setOnClickListener(this);

        et_search.addTextChangedListener(this);
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
        editable.toString();

        Log.i("textwatech",   "============"+editable.toString());
    }
}
