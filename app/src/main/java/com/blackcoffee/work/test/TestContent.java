package com.blackcoffee.work.test;

import android.widget.ListView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.entity.temp.ReportDay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/15.
 * 类描述
 * 版本
 */
public class TestContent {


    public static final String TEST_BUNDLE_KEY = "test_bundle_key";

    public static final String headUrl = "http://img.sportsv.net/img/photo/image/2/36682/aspect-jcOad0Axdv-500xauto.jpg";

    public static final String headUrl1 = "http://img1.imgtn.bdimg.com/it/u=2989180251,2413232656&fm=214&gp=0.jpg";

    public static final String headUrl2 = "http://www.hkbtv.cn/upload/article/1/2016/11/17/kqz2l0512m0.jpg";


    public static final String APPLICATION_LOCAL_TAG_CHECK_IN = "check_in";//考勤打卡
    public static final String APPLICATION_LOCAL_TAG_TAKE_BREAK = "take_break";//请假
    public static final String APPLICATION_LOCAL_TAG_REISSUE = "reissue";//补卡
    public static final String APPLICATION_LOCAL_TAG_GO_OUT = "go_out";//外出

    public static final String APPLICATION_LOCAL_TAG_BUSINESS_TRIP = "business_trip";//出差
    public static final String APPLICATION_LOCAL_TAG_OVER_TIME = "over_time";//加班
    public static final String APPLICATION_LOCAL_TAG_GOODS = "goods";//物品



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


    public static final String html = "<p>\n" +
            "\tThink Defferent\n" +
            "</p>\n" +
            "<p>\n" +
            "\tHere’s to the crazy ones. The misfits. The rebels. The troublemakers. The round pegs in the square holes. The ones who see things differently. They’re not fond of rules. And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them. About the only thing you can’t do is ignore them. Because they change things. They push the human race forward. And while some may see them as the crazy ones, we see genius. Because the people who are crazy enough to think they can change the world, are the ones who do.\n" +
            "</p>\n" +
            "<h1>\n" +
            "\t- Apple Inc.大西瓜\n" +
            "</h1>\n" +
            "<p>\n" +
            "\t<img src=\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517085727052&di=ac23a5f5bea899e9858f1c2cee05a3ea&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa5c27d1ed21b0ef47ecfc962d6c451da81cb3ee2.jpg\" alt=\"\" />\n" +
            "</p>\n" +
            "<p>\n" +
            "\t<br />\n" +
            "</p>";


    public static List<TestContact> getTestContacts() {


        List<TestContact> testContacts = new ArrayList<>();
        testContacts.add(new TestContact("张三"));
        testContacts.add(new TestContact("张四"));
        testContacts.add(new TestContact("张午"));
        testContacts.add(new TestContact("张器"));
        testContacts.add(new TestContact("赵二"));
        testContacts.add(new TestContact("王一"));
        testContacts.add(new TestContact("李四"));
        return testContacts;


    }


    public static List<TestApplicationMySection> getTestApplication() {


        List<TestApplicationMySection> testApplicationMySections = new ArrayList<>();
        testApplicationMySections.add(new TestApplicationMySection(true, "内外考勤"));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("考勤打卡", TestContent.APPLICATION_LOCAL_TAG_CHECK_IN)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("请假", TestContent.APPLICATION_LOCAL_TAG_TAKE_BREAK)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("补卡申请", TestContent.APPLICATION_LOCAL_TAG_REISSUE)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("外出", TestContent.APPLICATION_LOCAL_TAG_GO_OUT)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("出差", TestContent.APPLICATION_LOCAL_TAG_BUSINESS_TRIP)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("加班", TestContent.APPLICATION_LOCAL_TAG_OVER_TIME)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("物品", TestContent.APPLICATION_LOCAL_TAG_GOODS)));

        testApplicationMySections.add(new TestApplicationMySection(true, "工作汇报"));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("日报", TestContent.APPLICATION_LOCAL_TAG_REPORT_DAY)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("周报", TestContent.APPLICATION_LOCAL_TAG_REPORT_WEEK)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("月报", TestContent.APPLICATION_LOCAL_TAG_REPORT_MONTH)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("统计", TestContent.APPLICATION_LOCAL_TAG_REPORT_STATISTICS)));
//        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("日报", R.drawable.img_share_to)));
//        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("月报", R.drawable.img_my_group)));
//        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("统计", R.drawable.img_help)));


        testApplicationMySections.add(new TestApplicationMySection(true, "客户管理"));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("客户管理", TestContent.APPLICATION_LOCAL_TAG_MGR_CLIENT)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("产品管理", TestContent.APPLICATION_LOCAL_TAG_MGR_PRODUCT)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("活动管理", TestContent.APPLICATION_LOCAL_TAG_MGR_ACT)));
//        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("产品管理", R.drawable.img_share_to)));
//        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("活动管理", R.drawable.img_my_group)));


        testApplicationMySections.add(new TestApplicationMySection(true, "协同办公"));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("公告", TestContent.APPLICATION_LOCAL_TAG_ANNOUNCE)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("日志", TestContent.APPLICATION_LOCAL_TAG_DIARY)));
        testApplicationMySections.add(new TestApplicationMySection(new TestApplication("审批", TestContent.APPLICATION_LOCAL_TAG_APPROVE)));


        return testApplicationMySections;


    }


    /**
     * 客户列表
     *
     * @return
     */
    public static List<TestWork> getTestWorkClient() {


        List<TestWork> testWorks = new ArrayList<>();

        TestWork testWork = new TestWork(3, "客户有更新", "2018/3/26 15:23", "王富贵", "新建客户");

        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);

        return testWorks;


    }


    /**
     * 汇报列表
     *
     * @return
     */
    public static List<TestWork> getTestWorkReport() {


        List<TestWork> testWorks = new ArrayList<>();

        TestWork testWork = new TestWork(2, "工作汇报", "2018/3/26 15:23", "王富贵", "今日完成工作：今天完成了后天Ui界面设计，整体项目架构，拆分特有功能");

        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork);

        return testWorks;


    }


    /**
     * 审批列表
     *
     * @return
     */
    public static List<TestWork> getTestWorkApprove() {


        List<TestWork> testWorks = new ArrayList<>();

        TestWork testWork = new TestWork(1, "...", "2018/3/26 15:23", "王富贵", "审批内容：[物品名称]酒；[申请时间]2018-05-03 10:23；[申请备注]公司周年庆祝时使用",
                headUrl,
                "",
                "物品审批"
        );


        TestWork testWork1 = new TestWork(1, "...", "2018/3/26 15:23", "王富贵", "开始时间：2018-04-27 08:00 结束时间2018-4-28 18:30 由于家中临时有事因此请假",
                headUrl,
                "事假",
                "请假审批"
        );

        testWorks.add(testWork);
        testWorks.add(testWork1);
        testWorks.add(testWork1);
        testWorks.add(testWork);
        testWorks.add(testWork);
        testWorks.add(testWork1);
        testWorks.add(testWork1);
        testWorks.add(testWork);
        testWorks.add(testWork);

        return testWorks;


    }


    /**
     * 公告列表
     *
     * @return
     */
    public static List<TestWork> getTestWorkAnnounce() {


        List<TestWork> testWorks = new ArrayList<>();

        TestWork testWork = new TestWork(4, "C罗若离队或只有两个去处！重回曼联或PSG内马尔因此加盟皇马？", "2018/3/26 15:23", "Slim Shady", "新建客户");
        testWork.setAvatar(headUrl1);


        TestWork testWork1 = new TestWork(4, "两个赛季均有冠军入账，孔蒂就算离任，也无愧与切尔西", "2018/4/25 10:49", "王富贵", "新建客户");
        testWork1.setAvatar(headUrl2);

        testWorks.add(testWork);
        testWorks.add(testWork1);
        testWorks.add(testWork1);
        testWorks.add(testWork);
        testWorks.add(testWork1);
        testWorks.add(testWork);
        testWorks.add(testWork1);
        testWorks.add(testWork1);
        testWorks.add(testWork);

        return testWorks;

    }


    public static List<TestWork> getTestWorkAll() {


        List<TestWork> testWorks = new ArrayList<>();


        TestWork testWork1 = new TestWork(1, "...", "2018/3/26 15:23", "王富贵", "审批内容：[物品名称]酒；[申请时间]2018-05-03 10:23；[申请备注]公司周年庆祝时使用",
                headUrl,
                "",
                "物品审批"
        );


        TestWork testWork11 = new TestWork(1, "...", "2018/3/26 15:23", "王富贵", "开始时间：2018-04-27 08:00 结束时间2018-4-28 18:30 由于家中临时有事因此请假",
                headUrl,
                "事假",
                "请假审批"
        );


        TestWork testWork2 = new TestWork(2, "工作汇报", "2018/3/26 15:23", "王富贵", "今日完成工作：今天完成了后天Ui界面设计，整体项目架构，拆分特有功能");


        TestWork testWork3 = new TestWork(3, "客户有更新", "2018/3/26 15:23", "王富贵", "新建客户");

        TestWork testWork4 = new TestWork(4, "C罗若离队或只有两个去处！重回曼联或PSG内马尔因此加盟皇马？", "2018/3/26 15:23", "Slim Shady", "新建客户");
        testWork4.setAvatar(headUrl1);


        TestWork testWork44 = new TestWork(4, "两个赛季均有冠军入账，孔蒂就算离任，也无愧与切尔西", "2018/4/25 10:49", "王富贵", "新建客户");
        testWork44.setAvatar(headUrl2);

        testWorks.add(testWork1);
        testWorks.add(testWork4);
        testWorks.add(testWork11);
        testWorks.add(testWork2);
        testWorks.add(testWork3);
        testWorks.add(testWork4);
        testWorks.add(testWork44);


        testWorks.add(testWork11);
        testWorks.add(testWork44);
        testWorks.add(testWork4);
        testWorks.add(testWork3);
        testWorks.add(testWork3);
        testWorks.add(testWork1);
        testWorks.add(testWork2);
        return testWorks;

    }



    public static TestWork getTestWorkSingleTakeBreak() {


        TestWork testWork11 = new TestWork(1, "...", "2018/3/26 15:23", "王富贵", "开始时间：2018-04-27 08:00 结束时间2018-4-28 18:30 由于家中临时有事因此请假",
                headUrl,
                "事假",
                "请假审批"
        );

        return testWork11;

    }

    public static List<TestCheckIn> getTestCheckInAll() {


        List<TestCheckIn> testCheckIns = new ArrayList<>();
        TestCheckIn testCheckIn1 = new TestCheckIn("09:00", "08:57", "陕西省西安市团结南路99号", "正常");

        TestCheckIn testCheckIn2 = new TestCheckIn("18:00", "19:06", "陕西省西安市团结南路99号", "正常");
        testCheckIns.add(testCheckIn1);
        testCheckIns.add(testCheckIn2);
        return testCheckIns;

    }


    public static List<FileAdd> getTestFileAdd() {


        List<FileAdd> fileAdds = new ArrayList<>();
        FileAdd fileAdd0 = new FileAdd("", ConstLocalData.ADD);

        fileAdds.add(0,fileAdd0);
        return fileAdds;
    }



    public static List<ReportDay> getReportDayList() {


        ReportDay reportDay0 = new ReportDay(0,"写日报");
        ReportDay reportDay1 = new ReportDay(1,"查看日报");

        List<ReportDay> reportDays = new ArrayList<>();
        reportDays.add(reportDay0);
        reportDays.add(reportDay1);
        return reportDays;
    }
}