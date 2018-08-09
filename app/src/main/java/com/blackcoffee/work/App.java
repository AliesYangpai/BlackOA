package com.blackcoffee.work;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.blackcoffee.work.universal.img.ImgUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;

import org.litepal.LitePalApplication;

import java.io.File;

/**
 * Created by admin on 2018/5/4.
 * 类描述  项目App入口的Application
 * 版本
 */
public class App extends LitePalApplication implements Application.ActivityLifecycleCallbacks {


    public static final String TAG = App.class.getSimpleName();

    private static volatile App mInstance;




    public static App getInstance() {

        if(mInstance == null) {
            synchronized (App.class) {
                if(mInstance == null) {
                    mInstance = new App();
                }
            }
        }

        return mInstance;

    }



    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initImageLoader(mInstance);
        initNoHttp();

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }



    /**
     * 初始化ImageLoader
     */
    private void initImageLoader(Context context) {


        String cachePath = this.getCacheDir().getAbsolutePath() + File.separator + "imageCache/";

        File cacheDir = new File(cachePath);

        ImageLoaderConfiguration config = new
                ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 2)// 设置当前线程优先级
                .denyCacheImageMultipleSizesInMemory() // 缓存显示不同 大小的同一张图片
                .diskCacheSize(50 * 1024 * 1024) // 本地Sd卡的缓存最大值
                .diskCache(new UnlimitedDiscCache(cacheDir))// sd卡缓存
                .memoryCache(new WeakMemoryCache()) // 内存缓存
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();

        ImgUtil.getInstance().getImageLoader().init(config);


    }


    /**
     * 初始化网路请求框架
     */
    private void initNoHttp() {

        Logger.setDebug(true); // 开启NoHttp调试模式。
        Logger.setTag("NoHttpMyTest"); // 设置NoHttp打印Log的TAG。
        /**
         * 1.超时配置
         * 2.配置缓存 （实际就是数据的本地存储）
         * 3.配置Cookie
         * 4.配置网络层 （这大概是http网络层的异常处理）
         *
         */
        NoHttp.Config config = new NoHttp.Config();



        config.setConnectTimeout(30 * 1000); // 全局连接超时时间，单位毫秒。
        config.setReadTimeout(30 * 1000); // 全局服务器响应超时时间，单位毫秒。
        config.setNetworkExecutor(new OkHttpNetworkExecutor()); //2.配置网络层


        NoHttp.initialize(mInstance, config);


    }
}