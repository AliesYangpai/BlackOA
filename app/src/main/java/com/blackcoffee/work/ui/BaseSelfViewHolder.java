package com.blackcoffee.work.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/11/8.
 * 类描述
 * 版本
 */

public class BaseSelfViewHolder extends RecyclerView.ViewHolder  {



    public View itemView;


    public BaseSelfViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    protected <T extends View> T findOAViewById(int id) {

        return (T)itemView.findViewById(id) ;
    }
}
