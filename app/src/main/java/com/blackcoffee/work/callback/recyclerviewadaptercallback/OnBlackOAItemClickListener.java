package com.blackcoffee.work.callback.recyclerviewadaptercallback;

import android.view.View;

/**
 * Created by Administrator on 2017/11/8.
 * 类描述  自定义的 clickListener
 * 版本
 */

public interface OnBlackOAItemClickListener<T> {



    /**
     * tag  代表是哪个adapter
     * @param adapterTag
     * @param view
     * @param t
     */
    void onItemClick(String adapterTag,View view, int position, T t);

}
