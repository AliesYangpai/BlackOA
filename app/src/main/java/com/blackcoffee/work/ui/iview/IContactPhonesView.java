package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.IBaseView;

import java.util.List;

/**
 * Created by admin on 2018/5/30.
 * 类描述  手机联系人view
 * 版本
 */
public interface IContactPhonesView extends IBaseView {

    void doShowSelfContactFromDb(List<SelfContact> selfContacts);

    void onVertifyErrorNoContacts();
}