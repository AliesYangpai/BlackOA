package com.blackcoffee.work.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstSp;
import com.blackcoffee.work.presenter.PresenterWelcome;
import com.blackcoffee.work.ui.BaseActivity;
import com.blackcoffee.work.ui.iview.IWelcomeView;
import com.blackcoffee.work.ui.widget.bottomSpot.CirclePageIndicator;
import com.blackcoffee.work.ui.widget.bottomSpot.WelViewPagerAdapter;
import com.blackcoffee.work.universal.cache.sp.SpUtil;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends BaseActivity<IWelcomeView,PresenterWelcome> implements IWelcomeView{


    private PresenterWelcome presenterWelcome;


    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    private WelViewPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected PresenterWelcome creatPresenter() {


        if(null == presenterWelcome) {
            presenterWelcome = new PresenterWelcome(this);
        }
        return presenterWelcome;
    }

    @Override
    protected void initViews() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        View pager01 = getLayoutInflater().inflate(R.layout.view_single_page, null);
        View pager02 = getLayoutInflater().inflate(R.layout.view_single_page, null);
        View pager03 = getLayoutInflater().inflate(R.layout.view_single_page_go, null);

        ImageView pageImage01 = (ImageView) pager01.findViewById(R.id.wizard_image);
        ImageView pageImage02 = (ImageView) pager02.findViewById(R.id.wizard_image);
        RelativeLayout rl_page = (RelativeLayout) pager03.findViewById(R.id.rl_page);

        TextView tv_go = (TextView) pager03.findViewById(R.id.tv_go);

        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                presenterWelcome.doGoToMain();

            }
        });


        try {

            pageImage01.setBackgroundResource(R.drawable.welcome_page1);
            pageImage02.setBackgroundResource(R.drawable.welcome_page2);
            rl_page.setBackgroundResource(R.drawable.welcome_page3);

        } catch (Exception e) {

        }

        List<View> views = new ArrayList<View>();

        views.add(pager01);
        views.add(pager02);
        views.add(pager03);


        mAdapter = new WelViewPagerAdapter(views);

        viewPager.setAdapter(mAdapter);
        circlePageIndicator.setViewPager(viewPager, 0);
        circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }

    @Override
    protected void initListener() {

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
    public void doGoToLogin() {

        /**
         * 开始跳转到登录界面
         */


        SpUtil.getInstance().saveBooleanTosp(ConstSp.SP_KEY_LOAD_OR_NOT, true);


        openActivityAndFinishItself(MainActivity.class,null);
    }
}
