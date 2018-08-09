package com.blackcoffee.work.ui.fragment.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.child.PresenterFgWorkChildReport;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.WorkReportDetailActivity;
import com.blackcoffee.work.ui.adapter.WorkChildClientAdapter;
import com.blackcoffee.work.ui.adapter.WorkChildReportAdapter;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildReport;
import com.blackcoffee.work.util.ToastUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 汇报
 */
public class FragmentWorkChildReport extends BaseFragment<IFgWorkChildReport, PresenterFgWorkChildReport> implements
        IFgWorkChildReport,
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.RequestLoadMoreListener {


    public static final String TAG = FragmentWorkChildReport.class.getSimpleName();

    private PresenterFgWorkChildReport presenterFgWorkChildReport;


    /**
     * list
     *
     * @param savedInstanceState
     */

    private SwipeRefreshLayout srefresh_layout;
    private RecyclerView rv_list;
    private RecyclerView.LayoutManager layoutManager;
    private WorkChildReportAdapter workChildReportAdapter;


    /**
     * 数据相关
     * @param savedInstanceState
     */

    /**
     * 数据相关
     */
    private int currentSize = ConstLocalData.DEFAULT_INCREMENT_SIZE;//当前显示的数量 用于下拉差量更新    默认6 //加载刷新
    private int currentIndex = ConstLocalData.DEFUALT_LIST_INDEX;//用于上拉加载更多；       默认1       //加载刷新

    public FragmentWorkChildReport() {
        // Required empty public constructor
    }


    @Override
    protected PresenterFgWorkChildReport creatPresenter() {
        if (null == presenterFgWorkChildReport) {

            presenterFgWorkChildReport = new PresenterFgWorkChildReport(this);
        }

        return presenterFgWorkChildReport;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_work_child_report;
    }

    @Override
    protected void getSendData(Bundle arguments) {

    }

    @Override
    protected void initView() {
        /**
         * 刷新
         */

        srefresh_layout = findOAViewById(R.id.srefresh_layout);
        srefresh_layout.setColorSchemeColors(getSwipeRefreshColor());
        rv_list = findOAViewById(R.id.rv_list);
        layoutManager = new LinearLayoutManager(mActivity);
        workChildReportAdapter = new WorkChildReportAdapter(R.layout.item_fg_work_child_report);

        rv_list.setLayoutManager(layoutManager);

        rv_list.setAdapter(workChildReportAdapter);


        //默认第一次加载会进入回调，如果不需要可以配置
        workChildReportAdapter.disableLoadMoreIfNotFullPage(rv_list);
    }

    @Override
    protected void initListener() {
        srefresh_layout.setOnRefreshListener(this);
        workChildReportAdapter.setOnLoadMoreListener(this, rv_list);
        workChildReportAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void onLazyLoad() {
        workChildReportAdapter.setNewData(TestContent.getTestWorkReport());
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
    public void dismissFreshLoading() {
        srefresh_layout.setRefreshing(false);
    }

    @Override
    public void onDataBackFailInLoadMore(int code, String errorMsg) {
        workChildReportAdapter.loadMoreFail();
        ToastUtil.showMsg(mActivity.getApplicationContext(), errorMsg);
    }

    @Override
    public void onDataBackSuccessForGetWorkReports(List<TestWork> testWorks) {
        workChildReportAdapter.setNewData(testWorks);
    }

    @Override
    public void onDataBackSuccessForGetWorkReportsInFresh(List<TestWork> testWorks) {
        workChildReportAdapter.setNewData(testWorks);
    }

    @Override
    public void onDataBackSuccessForGetWorkReportsInLoadMore(List<TestWork> testWorks) {
        if (null != testWorks && testWorks.size() > 0) {

            workChildReportAdapter.addData(testWorks);
            workChildReportAdapter.loadMoreComplete();
            currentSize += ConstLocalData.DEFAULT_INCREMENT_SIZE;   //这是设置给 下拉刷新用的//加载刷新
            currentIndex += ConstLocalData.DEFUALT_LIST_INDEX;

        } else {

            workChildReportAdapter.loadMoreEnd();
        }
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
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        TestWork testWork = (TestWork) adapter.getData().get(position);

        ToastUtil.showMsg(mActivity.getApplicationContext(),testWork.getName());

        openActivity(WorkReportDetailActivity.class,null);
    }
}
