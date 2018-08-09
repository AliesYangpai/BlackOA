package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.constant.ConstError;
import com.blackcoffee.work.entity.ErrorEntity;
import com.blackcoffee.work.listener.OnDataBackListener;
import com.blackcoffee.work.logic.LogicAppItem;
import com.blackcoffee.work.method.IApplicationInfoConfig;
import com.blackcoffee.work.method.impl.IApplicationInfoConfigImpl;
import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.test.TestApplication;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.ui.activity.BusinessTripActivity;
import com.blackcoffee.work.ui.activity.CheckInActivity;
import com.blackcoffee.work.ui.activity.CheckInDailyRecordDailyActivity;
import com.blackcoffee.work.ui.activity.GoOutActivity;
import com.blackcoffee.work.ui.activity.GoodsActivity;
import com.blackcoffee.work.ui.activity.OverTimeActivity;
import com.blackcoffee.work.ui.activity.ReportDayActivity;
import com.blackcoffee.work.ui.activity.TakeBreakActivity;
import com.blackcoffee.work.ui.iview.fg.IFgAppView;
import com.blackcoffee.work.ui.iview.fg.IFgConnectView;

import java.util.List;

/**
 * Created by admin on 2018/5/9.
 * 类描述  应用fragment的界面管理者
 * 版本
 */
public class PresenterFgApp extends BasePresenter<IFgAppView> {

    private IFgAppView iFgAppView;
    private IApplicationInfoConfig iApplicationInfoConfig;

    private LogicAppItem logicAppItem;

    public PresenterFgApp(IFgAppView iFgAppView) {
        this.iFgAppView = iFgAppView;
        this.iApplicationInfoConfig = new IApplicationInfoConfigImpl();
        this.logicAppItem = new LogicAppItem();
    }


    /**
     * 获取信息配置列表
     *
     * @param url
     * @param size
     * @param index
     */
    public void doGetAppConfigRecords(String url, int size, int index) {


        iApplicationInfoConfig.doGetApplicationRecords(url, size, index, new OnDataBackListener() {
            @Override
            public void onStart() {
                iFgAppView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {


                List<TestApplicationMySection> list = parseSerilizable.getParseToList(data, TestApplicationMySection.class);

                if (vertifyNotNull.isNotNullListSize(list)) {
                    iFgAppView.onDataBackSuccessForGetAppConfig(list);
                }


            }

            @Override
            public void onFail(int code, String data) {
                ErrorEntity errorEntity = parseSerilizable.getParseToObj(data, ErrorEntity.class);
                if (vertifyNotNull.isNotNullObj(errorEntity)) {
                    iFgAppView.onDataBackFail(code, errorEntity.getError_message());
                } else {
                    iFgAppView.onDataBackFail(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);
                }
            }

            @Override
            public void onFinish() {

                iFgAppView.dismissLoadingDialog();

            }
        });


    }


    /**
     * 下拉刷新获取信息配置列表
     *
     * @param url
     * @param size
     * @param index
     */
    public void doGetAppConfigRecordInFresh(String url, int size, int index) {


        iApplicationInfoConfig.doGetApplicationRecords(url, size, index, new OnDataBackListener() {
            @Override
            public void onStart() {
                iFgAppView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {


                List<TestApplicationMySection> list = parseSerilizable.getParseToList(data, TestApplicationMySection.class);
                iFgAppView.onDataBackSuccessForGetAppConfigInFresh(list);

            }

            @Override
            public void onFail(int code, String data) {
                ErrorEntity errorEntity = parseSerilizable.getParseToObj(data, ErrorEntity.class);

                if (vertifyNotNull.isNotNullObj(errorEntity)) {

                    iFgAppView.onDataBackFail(code, errorEntity.getError_message());
                } else {

                    iFgAppView.onDataBackFail(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);

                }
            }

            @Override
            public void onFinish() {

                iFgAppView.dismissFreshLoading();

            }
        });


    }


    /**
     * 上拉加载更多
     *
     * @param url
     * @param size
     * @param index
     */
    public void doGetAppConfigRecordInLoadMore(String url, int size, int index) {


        iApplicationInfoConfig.doGetApplicationRecords(url, size, index, new OnDataBackListener() {
            @Override
            public void onStart() {
                iFgAppView.showLoadingDialog();
            }

            @Override
            public void onSuccess(String data) {


                List<TestApplicationMySection> list = parseSerilizable.getParseToList(data, TestApplicationMySection.class);
                iFgAppView.onDataBackSuccessForGetAppConfigInLoadMore(list);

            }

            @Override
            public void onFail(int code, String data) {

                ErrorEntity errorEntity = parseSerilizable.getParseToObj(data, ErrorEntity.class);
                if (vertifyNotNull.isNotNullObj(errorEntity)) {
                    iFgAppView.onDataBackFailInLoadMore(code, errorEntity.getError_message());
                } else {
                    iFgAppView.onDataBackFailInLoadMore(ConstError.DEFUAL_ERROR_CODE, ConstError.PARSE_ERROR_MSG);
                }
            }

            @Override
            public void onFinish() {

                iFgAppView.dismissFreshLoading();

            }
        });


    }


    public void doDealItenClick(TestApplicationMySection testApplicationMySection) {

        String localTag = testApplicationMySection.t.getLocalTag();
        if (logicAppItem.isCheckIn(localTag)) {
            iFgAppView.doGoToNextActivity(CheckInActivity.class,null);
            return;
        }

        if(logicAppItem.isTakeBreak(localTag)) {
            iFgAppView.doGoToNextActivity(TakeBreakActivity.class,null);
            return;
        }



        if(logicAppItem.isCheckReissue(localTag)) {
            iFgAppView.doGoToNextActivity(CheckInDailyRecordDailyActivity.class,null);
            return;
        }

        if(logicAppItem.isGoOut(localTag)) {

            iFgAppView.doGoToNextActivity(GoOutActivity.class,null);
            return;
        }





        if(logicAppItem.isBusinessTrip(localTag)) {
            iFgAppView.doGoToNextActivity(BusinessTripActivity.class,null);
            return;
        }

        if(logicAppItem.isOvrtTime(localTag)) {

            iFgAppView.doGoToNextActivity(OverTimeActivity.class,null);
            return;
        }

        if(logicAppItem.isGoods(localTag)) {
            iFgAppView.doGoToNextActivity(GoodsActivity.class,null);
            return;
        }






        if(logicAppItem.isReportDay(localTag)) {
            iFgAppView.doGoToNextActivity(ReportDayActivity.class,null);
            return;
        }


        if(logicAppItem.isReportWeek(localTag)) {
            return;
        }

        if(logicAppItem.isReportMonth(localTag)) {
            return;
        }

        if(logicAppItem.isReportStatistics(localTag)) {
            return;
        }

        if(logicAppItem.isMgrClient(localTag)) {
            return;
        }


        if(logicAppItem.isMgrProduct(localTag)) {
            return;
        }

        if(logicAppItem.isMgrAct(localTag)) {
            return;
        }

        if(logicAppItem.isAnnounce(localTag)) {
            return;
        }

        if(logicAppItem.isDiary(localTag)) {
            return;
        }

        if(logicAppItem.isApprove(localTag)) {
            return;
        }


    }

}