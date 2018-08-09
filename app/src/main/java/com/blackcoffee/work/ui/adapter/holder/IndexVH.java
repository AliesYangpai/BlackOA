package com.blackcoffee.work.ui.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackcoffee.work.R;

/**
 * Created by admin on 2018/5/31.
 * 类描述   联系人类表的 holder（index）
 * 版本
 */
public class IndexVH extends RecyclerView.ViewHolder {

    public  TextView tv;

    public IndexVH(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv_index);
    }
}