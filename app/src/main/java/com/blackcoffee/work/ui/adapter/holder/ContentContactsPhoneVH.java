package com.blackcoffee.work.ui.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;

/**
 * Created by admin on 2018/5/31.
 * 类描述   联系人类表的 holder（content）
 * 版本
 */
public class ContentContactsPhoneVH extends RecyclerView.ViewHolder {



    public CircleImageView civ_user_head;
    public TextView tv_contact_name;
    public TextView tv_contact_phone;
    public TextView tv_contact_phone_add;


    public ContentContactsPhoneVH(View itemView) {
        super(itemView);
        civ_user_head = (CircleImageView) itemView.findViewById(R.id.civ_user_head);
        tv_contact_name = (TextView) itemView.findViewById(R.id.tv_contact_name);
        tv_contact_phone = (TextView) itemView.findViewById(R.id.tv_contact_phone);
        tv_contact_phone_add = (TextView) itemView.findViewById(R.id.tv_contact_phone_add);
    }
}