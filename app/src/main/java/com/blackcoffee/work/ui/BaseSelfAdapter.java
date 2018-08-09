package com.blackcoffee.work.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAChildViewClickListener;
import com.blackcoffee.work.callback.recyclerviewadaptercallback.OnBlackOAItemClickListener;


/**
 * Created by Administrator on 2017/11/8.
 * 类描述
 * 版本
 */

public abstract class BaseSelfAdapter<V extends BaseSelfViewHolder> extends RecyclerView.Adapter<V> {


    public OnBlackOAChildViewClickListener onBlackOAChildViewClickListener;

    public OnBlackOAItemClickListener  onBlackOAItemClickListener;


    public void setOnBlackOAChildViewClickListener(OnBlackOAChildViewClickListener onBlackOAChildViewClickListener) {
        this.onBlackOAChildViewClickListener = onBlackOAChildViewClickListener;
    }

    public void setOnBlackOAItemClickListener(OnBlackOAItemClickListener onBlackOAItemClickListener) {
        this.onBlackOAItemClickListener = onBlackOAItemClickListener;
    }

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {


        View inflate = LayoutInflater.from(parent.getContext()).inflate(layoutId(), parent, false);
        return onBlackOACreateViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(V v, int position) {


        v.itemView.setTag(position);
        onBlackOABindViewHolder(v, position);

    }

    @Override
    public int getItemCount() {

        return getBlackOAItemCount();
    }


    protected abstract V onBlackOACreateViewHolder(View inflate);


    protected abstract void onBlackOABindViewHolder(V v, int position);

    protected abstract int layoutId();

    protected abstract int getBlackOAItemCount();

}
