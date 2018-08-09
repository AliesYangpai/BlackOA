package com.blackcoffee.work.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.presenter.PresenterAnnounceDetail;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IAnnounceDetialView;
import com.blackcoffee.work.ui.iview.IWebViewLoadView;
import com.blackcoffee.work.ui.widget.webview.WebClientPicDescrib;
import com.blackcoffee.work.util.ToastUtil;

/**
 * 公告详情界面
 */
public class AnnounceDetialActivity extends BaseActivity<IAnnounceDetialView, PresenterAnnounceDetail> implements IAnnounceDetialView,
        IWebViewLoadView,
        View.OnClickListener{


    private PresenterAnnounceDetail presenterAnnounceDetail;


    /**
     * title
     */
    private ImageView iv_common_back;
    private TextView tv_common_title;


    private TextView tv_announce_title;
    private TextView tv_create_time;
    private WebView wv_picAndDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce_detial);



        String html = TestContent.html;
        html = ConstLocalData.WEB_IMG_STYLE + html;
        wv_picAndDescription.loadDataWithBaseURL(null, html, ConstLocalData.MIME_TYPE, ConstLocalData.CODING_TYPE, null);
    }

    @Override
    protected PresenterAnnounceDetail creatPresenter() {
        if (null == presenterAnnounceDetail) {
            presenterAnnounceDetail = new PresenterAnnounceDetail(this);
        }
        return presenterAnnounceDetail;
    }


//    https://mb.yidianzixun.com/article/0JA2npnr?s=mb&appid=mibrowser&net=wifi

    @Override
    protected void initViews() {


        /**
         * title
         */
        iv_common_back = findOAViewById(R.id.iv_common_back);
        tv_common_title = findOAViewById(R.id.tv_common_title);
        tv_common_title.setText(R.string.work_notice);

        tv_announce_title = findOAViewById(R.id.tv_announce_title);
        tv_create_time = findOAViewById(R.id.tv_create_time);
        wv_picAndDescription = findOAViewById(R.id.wv_picAndDescription);

        wv_picAndDescription = findOAViewById(R.id.wv_picAndDescription);


        wv_picAndDescription = findOAViewById(R.id.wv_picAndDescription); //图文详情
        wv_picAndDescription.getSettings().setJavaScriptEnabled(true);
        wv_picAndDescription.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv_picAndDescription.getSettings().setDomStorageEnabled(true);
        wv_picAndDescription.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv_picAndDescription.setBackgroundColor(0x00000000);
        wv_picAndDescription.getSettings().setLoadWithOverviewMode(true);
        wv_picAndDescription.setWebViewClient(new WebClientPicDescrib(this, this));

    }

    @Override
    protected void initListener() {
        iv_common_back.setOnClickListener(this);
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
    public void onWebViewLoadFinsh() {
        dismissLoadDialog();
    }

    @Override
    public void doSetFocusOn() {
        tv_announce_title.setFocusable(true);
        tv_announce_title.setFocusableInTouchMode(true);
        tv_announce_title.requestFocus();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.iv_common_back:
                dofinishItself();
                break;
        }
    }
}
