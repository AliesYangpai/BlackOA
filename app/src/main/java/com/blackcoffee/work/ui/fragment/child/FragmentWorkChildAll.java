package com.blackcoffee.work.ui.fragment.child;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.EventEntity;
import com.blackcoffee.work.presenter.fg.child.PresenterFgWorkChildAll;
import com.blackcoffee.work.test.TestContent;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.activity.AnnounceDetialActivity;
import com.blackcoffee.work.ui.activity.WorkApproveDetialActivity;
import com.blackcoffee.work.ui.activity.WorkReportDetailActivity;
import com.blackcoffee.work.ui.adapter.WorkChildAllAdapter;
import com.blackcoffee.work.ui.adapter.WorkChildClientAdapter;
import com.blackcoffee.work.ui.iview.fg.child.IFgWorkChildAll;
import com.blackcoffee.work.util.ToastUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * 全部
 */
public class FragmentWorkChildAll extends BaseFragment<IFgWorkChildAll, PresenterFgWorkChildAll> implements
        IFgWorkChildAll,
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.RequestLoadMoreListener {


    public static final String TAG = FragmentWorkChildAll.class.getSimpleName();
    private PresenterFgWorkChildAll presenterFgWorkChildAll;


    /**
     * list
     *
     * @param savedInstanceState
     */

    private SwipeRefreshLayout srefresh_layout;
    private RecyclerView rv_list;
    private RecyclerView.LayoutManager layoutManager;
    private WorkChildAllAdapter workChildAllAdapter;


    /**
     * 数据相关
     * @param savedInstanceState
     */

    /**
     * 数据相关
     */
    private int currentSize = ConstLocalData.DEFAULT_INCREMENT_SIZE;//当前显示的数量 用于下拉差量更新    默认6 //加载刷新
    private int currentIndex = ConstLocalData.DEFUALT_LIST_INDEX;//用于上拉加载更多；       默认1       //加载刷新

    public FragmentWorkChildAll() {
        // Required empty public constructor
    }


    @Override
    protected PresenterFgWorkChildAll creatPresenter() {
        if (null == presenterFgWorkChildAll) {

            presenterFgWorkChildAll = new PresenterFgWorkChildAll(this);
        }

        return presenterFgWorkChildAll;
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_work_child_all;
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
        workChildAllAdapter = new WorkChildAllAdapter();

        rv_list.setLayoutManager(layoutManager);

        rv_list.setAdapter(workChildAllAdapter);

        //默认第一次加载会进入回调，如果不需要可以配置
        workChildAllAdapter.disableLoadMoreIfNotFullPage(rv_list);

    }

    @Override
    protected void initListener() {
        srefresh_layout.setOnRefreshListener(this);
        workChildAllAdapter.setOnLoadMoreListener(this, rv_list);
        workChildAllAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void onLazyLoad() {
        workChildAllAdapter.setNewData(TestContent.getTestWorkAll());
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

        workChildAllAdapter.loadMoreFail();
        ToastUtil.showMsg(mActivity.getApplicationContext(), errorMsg);
    }

    @Override
    public void onDataBackSuccessForGetWorkAll(List<TestWork> testWorks) {
        workChildAllAdapter.setNewData(testWorks);
    }

    @Override
    public void onDataBackSuccessForGetWorkAllInFresh(List<TestWork> testWorks) {
        workChildAllAdapter.setNewData(testWorks);
    }

    @Override
    public void onDataBackSuccessForGetWorkAllInLoadMore(List<TestWork> testWorks) {
        if (null != testWorks && testWorks.size() > 0) {

            workChildAllAdapter.addData(testWorks);
            workChildAllAdapter.loadMoreComplete();
            currentSize += ConstLocalData.DEFAULT_INCREMENT_SIZE;   //这是设置给 下拉刷新用的//加载刷新
            currentIndex += ConstLocalData.DEFUALT_LIST_INDEX;

        } else {

            workChildAllAdapter.loadMoreEnd();
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



        switch (testWork.getTag()) {

            case 1:
                Bundle bundle = new Bundle();
                bundle.putSerializable(TestContent.TEST_BUNDLE_KEY,testWork);
                openActivity(WorkApproveDetialActivity.class,bundle);
                break;

            case 2:
                openActivity(WorkReportDetailActivity.class,null);
                break;

            case 3:
                ToastUtil.showMsg(getContext(), "客户待定");
                break;


            case 4:
                openActivity(AnnounceDetialActivity.class,null);
                break;

        }
    }

}
