package com.blackcoffee.work.logic;

import com.blackcoffee.work.R;
import com.blackcoffee.work.test.TestContent;

/**
 * Created by admin on 2018/6/4.
 * 类描述  应用界面的相关配置逻辑
 * 版本
 */
public class LogicAppItem {



    public int getItemDrawable(String tag) {



//        public static String  = "go_out";//外出
//
//
//        public static String  = "report_day";//日报
//        public static String  = "report_week";//周报
//        public static String  = "report_month";//月报
//        public static String  = "statistics";//统计
//
//
//        public static String  = "mgr_client";//客户管理
//        public static String  = "mgr_product";//产品管理
//        public static String  = "mgr_act";//活动管理
//
//
//        public static String  = "announce";//公告
//        public static String APPLICATION_LOCAL_TAG_DIARY = "diary";//日志
//        public static String APPLICATION_LOCAL_TAG_APPROVE = "approve";//审批


        int drwableId = R.drawable.img_app_icon_client_mgr;
        switch (tag) {


            case TestContent.APPLICATION_LOCAL_TAG_CHECK_IN :   //打卡
                drwableId = R.drawable.img_app_icon_check_in;
                break;

            case TestContent.APPLICATION_LOCAL_TAG_TAKE_BREAK : //请假
                drwableId = R.drawable.img_app_icon_take_break;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_REISSUE :   //补卡
                drwableId = R.drawable.img_app_icon_check_in_reissue;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_GO_OUT : //外出
                drwableId = R.drawable.img_app_icon_go_out;
                break;



            case TestContent.APPLICATION_LOCAL_TAG_BUSINESS_TRIP : //出差
                drwableId = R.drawable.img_app_icon_bussiness_trip;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_OVER_TIME : //加班
                drwableId = R.drawable.img_app_icon_approve_over_time;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_GOODS : //物品
                drwableId = R.drawable.img_app_icon_goods;
                break;



            case TestContent.APPLICATION_LOCAL_TAG_REPORT_DAY : //r日报
                drwableId = R.drawable.img_app_icon_report_day;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_REPORT_WEEK :  //周报
                drwableId = R.drawable.img_app_icon_reoprt_week;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_REPORT_MONTH : //月报
                drwableId = R.drawable.img_app_icon_report_month;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_REPORT_STATISTICS : //统计
                drwableId = R.drawable.img_app_icon_statistic;
                break;


            case TestContent.APPLICATION_LOCAL_TAG_MGR_CLIENT :  //客户管理
                drwableId = R.drawable.img_app_icon_client_mgr;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_MGR_PRODUCT : //产品管理
                drwableId = R.drawable.img_app_icon_product_mgr;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_MGR_ACT :  //活动管理
                drwableId = R.drawable.img_app_icon_act_mgr;
                break;




            case TestContent.APPLICATION_LOCAL_TAG_ANNOUNCE :   //公告
                drwableId = R.drawable.img_app_icon_announce;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_DIARY :  //日志
                drwableId = R.drawable.img_app_icon_diary;
                break;
            case TestContent.APPLICATION_LOCAL_TAG_APPROVE : //审批
                drwableId = R.drawable.img_app_icon_approve;
                break;



        }

        return drwableId;


    }





    public static final String APPLICATION_LOCAL_TAG_REPORT_DAY = "report_day";//日报
    public static final String APPLICATION_LOCAL_TAG_REPORT_WEEK = "report_week";//周报
    public static final String APPLICATION_LOCAL_TAG_REPORT_MONTH = "report_month";//月报
    public static final String APPLICATION_LOCAL_TAG_REPORT_STATISTICS = "statistics";//统计


    public static final String APPLICATION_LOCAL_TAG_MGR_CLIENT = "mgr_client";//客户管理
    public static final String APPLICATION_LOCAL_TAG_MGR_PRODUCT = "mgr_product";//产品管理
    public static final String APPLICATION_LOCAL_TAG_MGR_ACT = "mgr_act";//活动管理


    public static final String APPLICATION_LOCAL_TAG_ANNOUNCE = "announce";//公告
    public static final String APPLICATION_LOCAL_TAG_DIARY = "diary";//日志
    public static final String APPLICATION_LOCAL_TAG_APPROVE = "approve";//审批



    /**
     * 打卡
     * @param tag
     * @return
     */
    public boolean isCheckIn(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_CHECK_IN);
    }



    /**
     * 请假
     * @param tag
     * @return
     */
    public boolean isTakeBreak(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_TAKE_BREAK);
    }


    /**
     * 补卡
     * @param tag
     * @return
     */
    public boolean isCheckReissue(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_REISSUE);
    }


    /**
     * 外出
     * @param tag
     * @return
     */
    public boolean isGoOut(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_GO_OUT);
    }


    /**
     * 出差
     * @param tag
     * @return
     */
    public boolean isBusinessTrip(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_BUSINESS_TRIP);
    }

    /**
     * 加班
     * @param tag
     * @return
     */
    public boolean isOvrtTime(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_OVER_TIME);
    }

    /**
     * 物品
     * @param tag
     * @return
     */
    public boolean isGoods(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_GOODS);
    }


    /**
     * 日报
     * @param tag
     * @return
     */
    public boolean isReportDay(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_REPORT_DAY);
    }

    /**
     * 周报
     * @param tag
     * @return
     */
    public boolean isReportWeek(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_REPORT_WEEK);
    }

    /**
     * 月报
     * @param tag
     * @return
     */
    public boolean isReportMonth(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_REPORT_MONTH);
    }

    /**
     * 统计
     * @param tag
     * @return
     */
    public boolean isReportStatistics(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_REPORT_STATISTICS);
    }




    /**
     * 客户管理
     * @param tag
     * @return
     */
    public boolean isMgrClient(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_MGR_CLIENT);
    }

    /**
     * 产品管理
     * @param tag
     * @return
     */
    public boolean isMgrProduct(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_MGR_PRODUCT);
    }

    /**
     * 活动管理
     * @param tag
     * @return
     */
    public boolean isMgrAct(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_MGR_ACT);
    }





    /**
     * 公告
     * @param tag
     * @return
     */
    public boolean isAnnounce(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_ANNOUNCE);
    }



    /**
     * 日志
     * @param tag
     * @return
     */
    public boolean isDiary(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_DIARY);
    }


    /**
     * 审批
     * @param tag
     * @return
     */
    public boolean isApprove(String tag) {

        return tag.equals(TestContent.APPLICATION_LOCAL_TAG_APPROVE);
    }

}