package com.blackcoffee.work.ui.adapter.forlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.test.TestContact;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/15.
 * 类描述
 * 版本
 */
public class TopContactAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<TestContact> list;


    private Bitmap bitmap;
    private FunctionText functionText;

    public TopContactAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.img_contact_bg);
        this.functionText = new FunctionText();
    }


    public List<TestContact> getList() {
        return list;
    }

    public void setList(List<TestContact> list) {
        if (null == list) {

            list = new ArrayList<>();
        }
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        if (null != list && list.size() > 0) {

            return list.size();
        }
        return 0;

    }

    @Override
    public Object getItem(int i) {

        if (null != list && list.size() > 0) {

            return list.get(i);
        }

        return null;

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        TestContact testContact = list.get(position);


        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_top_contact, null);
            vh.civ_user_head = (CircleImageView) convertView.findViewById(R.id.civ_user_head);
            vh.tv_contact_name = (TextView) convertView.findViewById(R.id.tv_contact_name);
            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.tv_contact_name.setText(testContact.getName());


        String targetName = functionText.getTargetName(testContact.getName());
        ImgUtil.getInstance().getImgFromNetByUrl("", vh.civ_user_head, new DrawableInText(targetName, 30, bitmap));
        return convertView;

    }


    class ViewHolder {
        CircleImageView civ_user_head;
        TextView tv_contact_name;
    }


}