package com.blackcoffee.work.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.adapter.holder.ContentContactsFriendVH;
import com.blackcoffee.work.ui.adapter.holder.ContentContactsPhoneVH;
import com.blackcoffee.work.ui.adapter.holder.IndexVH;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;

import me.yokeyword.indexablerv.IndexableAdapter;


/**
 * Created by YoKey on 16/10/8.
 */
public class ContactFriendsAdapter extends IndexableAdapter<SelfContact> {
    private LayoutInflater mInflater;
    private Bitmap bitmap;
    private FunctionText functionText;

    public ContactFriendsAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.img_contact_bg);
        this.functionText = new FunctionText();
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_letter_index, parent, false);
        return new IndexVH(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_contact_friend, parent, false);
        return new ContentContactsFriendVH(view);
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        IndexVH vh = (IndexVH) holder;
        vh.tv.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, SelfContact selfContact) {
        ContentContactsFriendVH vh = (ContentContactsFriendVH) holder;
        vh.tv_contact_name.setText(selfContact.getContactName());
        vh.tv_contact_phone.setText(selfContact.getContactNo());


        Log.i("textlong","文本长度："+selfContact.getContactName().length());

        String targetName = functionText.getTargetName(selfContact.getContactName());

        ImgUtil.getInstance().getImgFromNetByUrl(selfContact.getAvatuar(), vh.civ_user_head, new DrawableInText(targetName, 30, bitmap));


    }


}
