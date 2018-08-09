package com.blackcoffee.work.androidelement.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

import com.blackcoffee.work.constant.ConstLog;

/**
 * Created by admin on 2018/5/15.
 * 类描述
 * 版本
 */
public class TestContactProvider {

    private Context mContext;


    /** 获取库Phone表字段 **/
    private static final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.Contacts.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };

    /** 联系人显示名称 **/
    private static final int PHONES_DISPLAY_NAME = 0;

    /** 电话号码 **/
    private static final int PHONES_NUMBER = 1;

    /** 头像ID **/
    private static final int PHONES_PHOTO_ID = 2;

    /** 联系人的ID **/
    private static final int PHONES_CONTACT_ID = 3;


    public TestContactProvider(Context context) {
        this.mContext = context;
    }


    // 获取手机联系人
    public void getPhoneContacts() {
        // rely=(RelativeLayout) findViewById(R.id.relationId);
        ContentResolver resolver = mContext.getContentResolver();

        // 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                PHONES_PROJECTION, null, null, null);

        // 不为空
        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()) {

                // 得到手机号码
                String phoneNumber = phoneCursor.getString(PHONES_NUMBER);
                // 当手机号码为空的或者为空字段 跳过当前循环
                if (TextUtils.isEmpty(phoneNumber))
                    continue;

                // 得到联系人名称
                String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME);

                // 得到联系人ID
                Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID);

                // 得到联系人头像ID
                Long imgid = phoneCursor.getLong(PHONES_PHOTO_ID);



                // photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (imgid > 0) {
                    Uri uri = ContentUris.withAppendedId(
                            ContactsContract.Contacts.CONTENT_URI, contactid);

                } else {

                }


                Log.i(ConstLog.PROVIDER,"联系人名称："+contactName+" 手机号："+phoneNumber+" 联系人id："+contactid);

            }

            phoneCursor.close();

        }
    }
}