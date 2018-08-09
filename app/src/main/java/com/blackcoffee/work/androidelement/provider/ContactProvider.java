package com.blackcoffee.work.androidelement.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

import com.blackcoffee.work.constant.ConstLog;
import com.blackcoffee.work.constant.ConstProvider;
import com.blackcoffee.work.constant.ConstSign;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.util.HzToPinyinUtil;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.indexablerv.PinyinUtil;

/**
 * Created by admin on 2018/5/16.
 * 类描述  数据提供者 提供查询手机联系人数据
 * 版本
 */
public class ContactProvider {

    private ContentResolver contentResolver;
    private Context mContext;
    private Cursor cursor;

    /**
     * 获取库Phone表字段
     * 顺序为 id，名称，电话，头像id
     **/


    public ContactProvider(Context mContext) {
        this.mContext = mContext;
        // 获取手机联系人
        contentResolver = this.mContext.getContentResolver();

    }


    /**
     * 获取联系人列表
     */

    public List<SelfContact> doGetPhoneContacts() {


        List<SelfContact> selfContacts = null;

        cursor = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                ConstProvider.PROJECTION_CONTACTS,
                null,
                null,
                null);
        // 不为空
        if (cursor != null) {


            selfContacts = new ArrayList<>();

            while (cursor.moveToNext()) {

                // 得到联系人ID
                Long contactid = cursor.getLong(ConstProvider.PHONES_CONTACT_ID);
                // 得到联系人名称
                String contactName = cursor.getString(ConstProvider.PHONES_DISPLAY_NAME);
                // 得到联系人头像ID
                String phoneUrl = cursor.getString(ConstProvider.PHONES_PHOTO_URL);// photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的

                String contactPhone = cursor.getString(ConstProvider.PHONES_NUMBER);



                String shortLatter =HzToPinyinUtil.getInstance().getFirstPinYin(contactName);

                selfContacts.add(new SelfContact(contactid,contactName,phoneUrl,contactPhone,
                        PinyinUtil.getPingYin(contactName),shortLatter));
                Log.i(ConstLog.PROVIDER, "联系人名称：" + contactName + " 头像url：" + phoneUrl + " 联系人id：" + contactid);

            }

            cursor.close();

        }

        return selfContacts;

    }

//
//    /**
//     * 获取联系人详情
//     */
//    public void doGetPhoneContactInfo(long contactId) {
//
//        cursor = contentResolver.query(
//                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                ConstProvider.PROJECTION_CONTACT_INFO,
//                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + ConstSign.EQUAL_SIGN + contactId,
//                null,
//                null);
//        // 不为空
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//
//                // 得到联系人ID
//                Long contactid = cursor.getLong(ConstProvider.PHONES_CONTACT_ID);
//                // 得到联系人名称
//                String contactName = cursor.getString(ConstProvider.PHONES_DISPLAY_NAME);
//                // 得到联系人头像ID
//                Long imgid = cursor.getLong(ConstProvider.PHONES_PHOTO_ID);// photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
//
//                String contactPhone = cursor.getString(ConstProvider.PHONES_NUMBER);
//
//                Log.i(ConstLog.PROVIDER, "联系人名称：" + contactName + " 头像id：" + imgid + " 联系人id：" + contactid + " 电话号码：" + contactPhone);
//
//            }
//
//            cursor.close();
//
//        }
//
//    }
}