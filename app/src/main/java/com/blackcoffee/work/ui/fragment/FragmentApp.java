package com.blackcoffee.work.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.App;
import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.PresenterFgApp;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.CheckInActivity;
import com.blackcoffee.work.ui.adapter.ApplicationAdapter;
import com.blackcoffee.work.ui.iview.fg.IFgAppView;

import com.blackcoffee.work.ui.widget.RecycleViewDivider;
import com.blackcoffee.work.util.ToastUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 应用fragment
 */
public class FragmentApp extends BaseFragment<IFgAppView, PresenterFgApp> implements
        IFgAppView,
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemChildClickListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    public static final String TAG = FragmentApp.class.getSimpleName();
    private PresenterFgApp presenterFgApp;


    /**
     * title
     */
    private TextView tv_common_title;


    /**
     * list
     *
     * @param savedInstanceState
     */

    private SwipeRefreshLayout srefresh_layout;
    private RecyclerView rv_list;
    private RecyclerView.LayoutManager layoutManager;
    private ApplicationAdapter applicationAdapter;


    /**
     * 数据相关
     * @param savedInstanceState
     */

    /**
     * 数据相关
     */
    private int currentSize = ConstLocalData.DEFAULT_INCREMENT_SIZE;//当前显示的数量 用于下拉差量更新    默认6 //加载刷新
    private int currentIndex = ConstLocalData.DEFUALT_LIST_INDEX;//用于上拉加载更多；       默认1       //加载刷新


    private ImageView iv_head;

    /**
     * 初始化头部的view
     *
     * @return
     */
    private View doInitHeadView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_application_top_head, null);
        iv_head = (ImageView) view.findViewById(R.id.iv_application_top);
        return view;
    }

    @Override
    protected PresenterFgApp creatPresenter() {

        if (null == presenterFgApp) {
            presenterFgApp = new PresenterFgApp(this);
        }


        return presenterFgApp;

    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_app;
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
        tv_common_title.setText(R.string.app);

        /**
         * 刷新
         */
        srefresh_layout = findOAViewById(R.id.srefresh_layout);
        srefresh_layout.setColorSchemeColors(getSwipeRefreshColor());
        rv_list = findOAViewById(R.id.rv_list);
        layoutManager = new GridLayoutManager(mActivity, ConstLocalData.DEFUALT_APP_SINGLE_COUNT);
        applicationAdapter = new ApplicationAdapter(R.layout.item_application_section_content, R.layout.item_application_section_head, null);

        applicationAdapter.addHeaderView(doInitHeadView());
        rv_list.setLayoutManager(layoutManager);
        rv_list.setAdapter(applicationAdapter);



        //默认第一次加载会进入回调，如果不需要可以配置
        applicationAdapter.disableLoadMoreIfNotFullPage(rv_list);

    }

    @Override
    protected void initListener() {


        srefresh_layout.setOnRefreshListener(this);
        applicationAdapter.setOnLoadMoreListener(this, rv_list);
        applicationAdapter.setOnItemChildClickListener(this);
    }

    @Override
    protected void onLazyLoad() {

        applicationAdapter.setNewData(TestContent.getTestApplication());
        iv_head.setImageResource(R.drawable.img_application_head);
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
    public void dismissFreshLoading() {
        srefresh_layout.setRefreshing(false);
    }

    @Override
    public void onDataBackFailInLoadMore(int code, String errorMsg) {
        applicationAdapter.loadMoreFail();
        ToastUtil.showMsg(mActivity.getApplicationContext(), errorMsg);
    }

    @Override
    public void onDataBackSuccessForGetAppConfig(List<TestApplicationMySection> testApplicationMySections) {
        applicationAdapter.setNewData(testApplicationMySections);
    }

    @Override
    public void onDataBackSuccessForGetAppConfigInFresh(List<TestApplicationMySection> testApplicationMySections) {
        applicationAdapter.setNewData(testApplicationMySections);
    }

    @Override
    public void onDataBackSuccessForGetAppConfigInLoadMore(List<TestApplicationMySection> testApplicationMySections) {
        if (null != testApplicationMySections && testApplicationMySections.size() > 0) {

            applicationAdapter.addData(testApplicationMySections);
            applicationAdapter.loadMoreComplete();
            currentSize += ConstLocalData.DEFAULT_INCREMENT_SIZE;   //这是设置给 下拉刷新用的//加载刷新
            currentIndex += ConstLocalData.DEFUALT_LIST_INDEX;

        } else {

            applicationAdapter.loadMoreEnd();
        }
    }

    @Override
    public void doGoToNextActivity(Class<?> targetClass, Bundle bundle) {
        openActivity(targetClass,bundle);
    }

    @Override
    public void onRefresh() {

//        presenterFgApp.doGetAppConfigRecordInFresh(
//                HttpConst.URL.NEWS_CONTENT,
//                currentSize,
//                ConstLocalData.DEFUALT_LIST_INDEX);
    }



    @Override
    public void onLoadMoreRequested() {
        int tempIndex = currentIndex + ConstLocalData.DEFUALT_LIST_INDEX;

//        presenterFgApp.doGetAppConfigRecordInLoadMore(
//                HttpConst.URL.NEWS_CONTENT,
//                ConstLocalData.DEFAULT_INCREMENT_SIZE,
//                tempIndex);


        Log.i("onLoadMore", "=============ChildFragmentFullLoad=onLoadMoreRequested");
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

        TestApplicationMySection testApplicationMySection = (TestApplicationMySection) adapter.getData().get(position);


        ToastUtil.showMsg(getActivity(),position +" "+ testApplicationMySection.t.getItemName());
        Log.i("the_position", "当前项目：" + position + " " + testApplicationMySection.isHeader+" 名称："+testApplicationMySection.t.getItemName());



        presenterFgApp.doDealItenClick(testApplicationMySection);



    }
}
