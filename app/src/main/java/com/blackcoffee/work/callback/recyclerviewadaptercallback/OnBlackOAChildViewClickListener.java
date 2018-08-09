package com.blackcoffee.work.callback.recyclerviewadaptercallback;

import android.view.View;

/**
 * Created by Administrator on 2017/11/8.
 * 类描述  自定义的 clickListene
 * 版本
 */

public interface OnBlackOAChildViewClickListener<T> {


    /**
     * tag  代表是哪个adapter
     * @param adapterTag
     * @param view
     * @param t
     */
    void onChildClick(String adapterTag,View view, T t);

}
