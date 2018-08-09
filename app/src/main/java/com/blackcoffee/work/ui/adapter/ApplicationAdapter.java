package com.blackcoffee.work.ui.adapter;

import android.support.annotation.LayoutRes;
import android.widget.ImageView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.logic.LogicAppItem;
import com.blackcoffee.work.test.TestApplication;
import com.blackcoffee.work.test.TestApplicationMySection;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * Created by Administrator on 2017/11/20.
 * 类描述
 * 版本
 */

public class ApplicationAdapter extends BaseSectionQuickAdapter<TestApplicationMySection, BaseViewHolder> {


    private LogicAppItem logicAppItem;

    public ApplicationAdapter(int layoutResId, int sectionHeadResId, List<TestApplicationMySection> data) {
        super(layoutResId, sectionHeadResId, data);
        logicAppItem = new LogicAppItem();
    }


    @Override
    protected void convertHead(BaseViewHolder helper, TestApplicationMySection item) {


        helper.setText(R.id.tv_item_name, item.header);

    }

    @Override
    protected void convert(BaseViewHolder helper, TestApplicationMySection item) {


        ImageView iv_item = helper.getView(R.id.iv_item);
        helper.setText(R.id.tv_item_text, item.t.getItemName())
                .addOnClickListener(R.id.iv_item);

        iv_item.setImageResource(logicAppItem.getItemDrawable(item.t.getLocalTag()));



//        ImgUtil.getInstance().getRadiusImgFromNetByUrl(item.t.getItemUrl(), iv_item, 10);


    }




}
