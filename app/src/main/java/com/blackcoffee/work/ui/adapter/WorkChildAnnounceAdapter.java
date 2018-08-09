package com.blackcoffee.work.ui.adapter;

import android.widget.ImageView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作的child 公告Adapter
 * 版本
 */
public class WorkChildAnnounceAdapter extends BaseQuickAdapter<TestWork, BaseViewHolder> {


    public WorkChildAnnounceAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, TestWork item) {




        helper.setText(R.id.tv_announce_title, item.getTitle())
                .setText(R.id.tv_announce_time, item.getTime())
                .setText(R.id.tv_author, item.getName());
        ImageView iv_announce = helper.getView(R.id.iv_announce);

        ImgUtil.getInstance().getRadiusImgFromNetByUrl(item.getAvatar(),iv_announce, ConstLocalData.IMG_RADIUS_5);
    }
}