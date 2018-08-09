package com.blackcoffee.work.ui.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.blackcoffee.work.R;
import com.blackcoffee.work.presenter.PresenterMain;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.fragment.FragmentChatMsg;
import com.blackcoffee.work.ui.iview.IMainView;
import com.blackcoffee.work.util.ToastUtil;

public class MainActivity extends BaseActivity<IMainView, PresenterMain> implements IMainView,
        BottomNavigationBar.OnTabSelectedListener {

    private PresenterMain presenterMain;


    private BottomNavigationBar bottom_navigation_bar;
    private BottomNavigationItem itemMsg;
    private BottomNavigationItem itemConnect;
    private BottomNavigationItem itemWork;
    private BottomNavigationItem itemTest;
    private BottomNavigationItem itemUser;
    private TextBadgeItem badgeItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenterMain.doGetDifferentFragment(FragmentChatMsg.TAG);

        badgeItem.setBackgroundColor(Color.parseColor("#ff0000"));
        badgeItem.setText("99+");
    }

    @Override
    protected PresenterMain creatPresenter() {
        if (null == presenterMain) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            presenterMain = new PresenterMain(this, fragmentManager, fragmentManager.beginTransaction());
        }

        return presenterMain;
    }

    @Override
    protected void initViews() {

        /**
         * 1.初始化图片和文字
         * 2.设置颜色
         */

        bottom_navigation_bar = findOAViewById(R.id.bottom_navigation_bar);
        itemMsg = new BottomNavigationItem(R.drawable.img_bottom_msg, getString(R.string.msg));
        itemConnect = new BottomNavigationItem(R.drawable.img_bottom_contact, getString(R.string.connect));
        itemWork = new BottomNavigationItem(R.drawable.img_bottom_work, getString(R.string.work));
        itemTest = new BottomNavigationItem(R.drawable.img_bottom_applicate, getString(R.string.app));
        itemUser = new BottomNavigationItem(R.drawable.img_bottom_mine, getString(R.string.mine));

        itemMsg.setActiveColorResource(R.color.bottom_click);
        itemConnect.setActiveColorResource(R.color.bottom_click);
        itemWork.setActiveColorResource(R.color.bottom_click);
        itemTest.setActiveColorResource(R.color.bottom_click);
        itemUser.setActiveColorResource(R.color.bottom_click);


        badgeItem = new TextBadgeItem();//当选中状态时消失，非选中状态显示
        badgeItem.setHideOnSelect(false);
        badgeItem.setBackgroundColor(android.R.color.transparent);
        itemMsg.setBadgeItem(badgeItem);


        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);   // TODO 设置模式
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);


        bottom_navigation_bar
                .addItem(itemMsg)
                .addItem(itemConnect)
                .addItem(itemWork)
                .addItem(itemTest)
                .addItem(itemUser)
                .setFirstSelectedPosition(0)
                .initialise();

        bottom_navigation_bar.setTabSelectedListener(this);


    }

    @Override
    protected void initListener() {

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
    public void onTabSelected(int position) {





        presenterMain.doGetDifferentFragmentByPosition(position);


//        switch (position) {
//
//            case 2:
//
//
//
//                openActivity(WorkAddAddActivity.class,null);
//                break;
//
//            default:
//                presenterMain.doGetDifferentFragmentByPosition(position);
//                break;
//
//        }

//        ToastUtil.showMsg(getApplicationContext(),"当前选中项："+position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
