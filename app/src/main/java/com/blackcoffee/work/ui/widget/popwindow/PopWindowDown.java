package com.blackcoffee.work.ui.widget.popwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.blackcoffee.work.R;
import com.blackcoffee.work.callback.popwindow.OnPopwindowDownDismissCallBack;

/**
 * Created by admin on 2018/6/8.
 * 类描述
 * 版本
 */
public class PopWindowDown implements PopupWindow.OnDismissListener {


    private Context context;
    private View contentView;
    private View relayView;
    private PopupWindow popupWindow;

    private OnPopwindowDownDismissCallBack onPopwindowDownDismissCallBack;


    public void setOnPopwindowDownDismissCallBack(OnPopwindowDownDismissCallBack onPopwindowDownDismissCallBack) {
        this.onPopwindowDownDismissCallBack = onPopwindowDownDismissCallBack;
    }

    public PopWindowDown(Context context, View contentView, View relayView){
        this.context = context;
        this.contentView = contentView;
        this.relayView = relayView;


        //内容，高度，宽度
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        //动画效果
        popupWindow.setAnimationStyle(R.style.AnimationTopFade);
        //菜单背景色
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
//        ColorDrawable dw = new ColorDrawable(0x0000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setOutsideTouchable(true);



        initListener();

    }



    private void initListener() {

        popupWindow.setOnDismissListener(this);
    }




    public void show(){
        //显示位置
        popupWindow.showAsDropDown(relayView);
    }
    public void hide(){
        if(popupWindow != null && popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }


    @Override
    public void onDismiss() {


        if(null != onPopwindowDownDismissCallBack) {
            onPopwindowDownDismissCallBack.onPopWindowDownDismiss();
        }
    }
}