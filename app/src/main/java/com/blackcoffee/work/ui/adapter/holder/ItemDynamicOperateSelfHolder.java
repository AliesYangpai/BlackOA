package com.blackcoffee.work.ui.adapter.holder;

import android.view.View;
import android.widget.ImageView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.ui.BaseSelfViewHolder;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2018/6/7.
 * 类描述
 * 版本
 */
public class ItemDynamicOperateSelfHolder extends BaseSelfViewHolder {


    public ImageView iv_operate;

    public ItemDynamicOperateSelfHolder(View view) {
        super(view);

        iv_operate = findOAViewById(R.id.iv_operate);

    }
}