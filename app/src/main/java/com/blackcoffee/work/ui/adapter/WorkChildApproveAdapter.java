package com.blackcoffee.work.ui.adapter;

import com.blackcoffee.work.R;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2018/5/27.
 * 类描述  工作的child 审批Adapter
 * 版本
 */
public class WorkChildApproveAdapter extends BaseQuickAdapter<TestWork, BaseViewHolder> {


    public WorkChildApproveAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper, TestWork item) {






        helper.setText(R.id.tv_work_approve_name,item.getName())
                .setText(R.id.tv_work_approve_title_text,"审批")
                .setText(R.id.tv_work_approve_info_title,item.getDescribTitle())
                .setText(R.id.tv_work_approve_info_type,item.getApproveType())
                .setText(R.id.tv_work_approve_info,item.getDescrib())
                .setText(R.id.tv_approve_time,item.getTime());

        CircleImageView civ_user_head =  helper.getView(R.id.civ_user_head);

        ImgUtil.getInstance().getImgFromNetByUrl(item.getAvatar(),civ_user_head,R.drawable.test_img_head_round);



    }
}