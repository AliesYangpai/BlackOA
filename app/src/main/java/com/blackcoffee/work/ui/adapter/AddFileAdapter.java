package com.blackcoffee.work.ui.adapter;

import android.view.View;

import com.blackcoffee.work.R;
import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.BaseSelfAdapter;
import com.blackcoffee.work.ui.adapter.holder.ItemDynamicOperateSelfHolder;
import com.blackcoffee.work.universal.img.ImgUtil;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/7.
 * 类描述
 * 版本
 */
public class AddFileAdapter extends BaseSelfAdapter<ItemDynamicOperateSelfHolder> {


    public static final String Tag = AddFileAdapter.class.getSimpleName();

    private List<FileAdd> list;

    private LogicViewRecycleView logicViewRecycleView;

    public List<FileAdd> getList() {
        return list;
    }

    public AddFileAdapter() {
        this.logicViewRecycleView = new LogicViewRecycleView();
    }

    public void setList(List<FileAdd> list) {

        if (null == list) {
            list = new ArrayList<>();
        }
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    protected ItemDynamicOperateSelfHolder onBlackOACreateViewHolder(View inflate) {

        ItemDynamicOperateSelfHolder itemDynamicOperateSelfHolder = new ItemDynamicOperateSelfHolder(inflate);


        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onBlackOAItemClickListener) {

                    Integer position = (Integer) view.getTag();

                    onBlackOAItemClickListener.onItemClick(Tag,view, position, list.get(position));
                }
            }
        });


        return itemDynamicOperateSelfHolder;

    }

    @Override
    protected void onBlackOABindViewHolder(ItemDynamicOperateSelfHolder itemDynamicOperateSelfHolder, int position) {

        final FileAdd fileAdd = list.get(position);

        if (logicViewRecycleView.isOperateAdd(fileAdd.getTag())) {
            itemDynamicOperateSelfHolder.iv_operate.setImageResource(R.drawable.img_adapter_pic_add);
        }else {
            ImgUtil.getInstance().getRadiusImgFromNetByUrl(fileAdd.getUrl(), itemDynamicOperateSelfHolder.iv_operate, 10);
        }

        itemDynamicOperateSelfHolder.iv_operate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (null != onBlackOAChildViewClickListener) {

                    onBlackOAChildViewClickListener.onChildClick(Tag,view, fileAdd);
                }

            }
        });


    }

    @Override
    protected int layoutId() {
        return R.layout.item_dynamic_operate;
    }

    @Override
    protected int getBlackOAItemCount() {
        if (null != list && list.size() > 0) {
            return list.size();
        }
        return 0;
    }
}