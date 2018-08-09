package com.blackcoffee.work.ui.adapter;

import android.widget.ImageView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.constant.ConstLocalData;
import com.blackcoffee.work.test.TestWork;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;


/**
 * Created by admin on 2018/5/27.
 * 类描述  工作的child  全部Adapter
 * 版本
 */


public class WorkChildAllAdapter extends BaseQuickAdapter<TestWork, BaseViewHolder> {


    public WorkChildAllAdapter() {
        super(null);
        //Step.1 setMultiTypeDelegate(), 并重写getItemType() 方法
        // 需要说明的是Entity 并不需要实现任何接口 ，只需要能够判断出该实体对应的是哪个布局类型即可
        setMultiTypeDelegate(new MultiTypeDelegate<TestWork>() {
            @Override
            protected int getItemType(TestWork item) {
                //infer the type by entity

                return item.getTag();
            }
        });


        //Step.2 getMultiTypeDelegate().registerItemType() 设置每种type对应的布局
        getMultiTypeDelegate()
                .registerItemType(ConstLocalData.ADATER_APPROVE, R.layout.item_fg_work_child_approve) //审批
                .registerItemType(ConstLocalData.ADATER_REPORT, R.layout.item_fg_work_child_report) //汇报
                .registerItemType(ConstLocalData.ADATER_CLIENT, R.layout.item_fg_work_child_client) //客户
                .registerItemType(ConstLocalData.ADATER_ANNOUNCE, R.layout.item_fg_work_child_announce_rough_line);//公告
    }

    @Override
    protected void convert(BaseViewHolder helper, TestWork item) {

        //Step.3分 type 进行 convert() 操作
        switch (helper.getItemViewType()) {

            case ConstLocalData.ADATER_APPROVE: //审批

                helper.setText(R.id.tv_work_approve_name, item.getName())
                        .setText(R.id.tv_work_approve_title_text, "审批")
                        .setText(R.id.tv_work_approve_info_title, item.getDescribTitle())
                        .setText(R.id.tv_work_approve_info_type, item.getApproveType())
                        .setText(R.id.tv_work_approve_info, item.getDescrib())
                        .setText(R.id.tv_approve_time, item.getTime());

                CircleImageView civ_user_head = helper.getView(R.id.civ_user_head);

                ImgUtil.getInstance().getImgFromNetByUrl(item.getAvatar(), civ_user_head, R.drawable.test_img_head_round);


                break;


            case ConstLocalData.ADATER_REPORT: //汇报
                // do something


                helper.setText(R.id.tv_work_report_title, item.getTitle())
                        .setText(R.id.tv_work_report_info_title, item.getName())
                        .setText(R.id.tv_work_report_info_title, item.getName())
                        .setText(R.id.tv_work_report_info, item.getDescrib())
                        .setText(R.id.tv_report_time, item.getTime());

                break;


            case ConstLocalData.ADATER_CLIENT://客户
                // do something

                helper.setText(R.id.tv_work_client_title, item.getTitle())
                        .setText(R.id.tv_work_client_info_name1, item.getName())
                        .setText(R.id.tv_work_client_info_name2, item.getName())
                        .setText(R.id.tv_work_client_info, item.getDescrib())
                        .setText(R.id.tv_client_time, item.getTime());
                break;

            case ConstLocalData.ADATER_ANNOUNCE://公告
                helper.setText(R.id.tv_announce_title, item.getTitle())
                        .setText(R.id.tv_announce_time, item.getTime())
                        .setText(R.id.tv_author, item.getName());
                ImageView iv_announce = helper.getView(R.id.iv_announce);

                ImgUtil.getInstance().getRadiusImgFromNetByUrl(item.getAvatar(), iv_announce, ConstLocalData.IMG_RADIUS_5);
                break;
        }


    }
}



