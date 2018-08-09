package com.blackcoffee.work.presenter;

import com.blackcoffee.work.universal.parse.ParseSerilizable;
import com.blackcoffee.work.universal.verification.VertifyNotNull;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/11/2.
 * 类描述
 * 版本
 */

public abstract class BasePresenter<V>  {



    protected WeakReference<V> viewWeakReference;


    protected ParseSerilizable parseSerilizable = new ParseSerilizable();
    protected VertifyNotNull vertifyNotNull = new VertifyNotNull();




    public void attachView(V view) {

        viewWeakReference  = new WeakReference<V>(view);


    }




    public void detachView() {

        if(null != viewWeakReference) {

            viewWeakReference.clear();

            viewWeakReference = null;

        }
        parseSerilizable = null;
        vertifyNotNull = null;

    }

}
