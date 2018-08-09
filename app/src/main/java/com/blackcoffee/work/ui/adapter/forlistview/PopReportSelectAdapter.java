package com.blackcoffee.work.ui.adapter.forlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.entity.temp.ReportDay;
import com.blackcoffee.work.ui.widget.DrawableInText;
import com.blackcoffee.work.ui.widget.cirlceimageview.CircleImageView;
import com.blackcoffee.work.universal.function.FunctionText;
import com.blackcoffee.work.universal.img.ImgUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/8.
 * 类描述
 * 版本
 */
public class PopReportSelectAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<ReportDay> list;

    private int currentTag;

    public PopReportSelectAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }

    public int getCurrentTag() {
        return currentTag;
    }

    public void setCurrentTag(int currentTag) {
        this.currentTag = currentTag;
        this.notifyDataSetChanged();
    }

    public List<ReportDay> getList() {
        return list;
    }

    public void setList(List<ReportDay> list,int tag) {
        if (null == list) {

            list = new ArrayList<>();
        }
        this.list = list;
        this.currentTag = tag;
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

        ReportDay reportDay = list.get(position);


        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_popwindow_report_select, null);
            vh.tv_report = (TextView) convertView.findViewById(R.id.tv_report);
            vh.iv_report_check = (ImageView) convertView.findViewById(R.id.iv_report_check);

            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }


        vh.tv_report.setText(reportDay.getTypeName());

        if(currentTag == reportDay.getType()) {
            vh.tv_report.setTextColor(Color.parseColor("#30baff"));
            vh.iv_report_check.setVisibility(View.VISIBLE);
        }else {

            vh.tv_report.setTextColor(Color.parseColor("#000000"));
            vh.iv_report_check.setVisibility(View.GONE);

        }

        return convertView;

    }


    class ViewHolder {


        TextView tv_report;
        ImageView iv_report_check;

    }
}