package com.blackcoffee.work.ui.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;

/**
 * Created by admin on 2018/5/27.
 * 类描述 自定义 drawable，用来实现  模仿钉钉 文字头像
 * 版本
 */
public class DrawableInText extends Drawable {


    private String text;
    private Paint mPaint;
    private Bitmap mBitmap;
    private RectF rectF;

    private Paint textPaint;
    private int fontSize;

    public DrawableInText(String text, int fontSize,Bitmap mBitmap) {
        this.text = text;
        this.mBitmap = mBitmap;
        this.fontSize = fontSize;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(Color.parseColor("#1296DB"));
        mPaint.setStyle(Paint.Style.FILL);


        textPaint = new Paint();
        textPaint.setAntiAlias(true);//抗锯齿
        textPaint.setColor(Color.WHITE);
        textPaint.setFlags(1);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(fontSize);

        Log.i("diy_drwable","DrawableInText================");

    }

    @Override
    public void draw(@NonNull Canvas canvas) {




        Rect r = getBounds();


        int width = r.width();
        int height = r.height();

        canvas.drawRoundRect(rectF, r.centerX(), r.centerY(), mPaint);


        canvas.drawText(text, width / 2, height / 2 - ((textPaint.descent() + textPaint.ascent()) / 2), textPaint);
        Log.i("diy_drwable","draw================");
    }

    @Override
    public void setAlpha(int i) {

        mPaint.setAlpha(i);
        Log.i("diy_drwable","setAlpha================");
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        Log.i("diy_drwable","setColorFilter================");
    }

    @Override
    public int getOpacity() {
        Log.i("diy_drwable","getOpacity================");
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
        Log.i("diy_drwable","setBounds================");
    }

    @Override
    public int getIntrinsicHeight() {

        Log.i("diy_drwable","getIntrinsicHeight================");
        return mBitmap.getHeight();
    }


    @Override
    public int getIntrinsicWidth() {
        Log.i("diy_drwable","getIntrinsicWidth================");
        return mBitmap.getWidth();
    }


}