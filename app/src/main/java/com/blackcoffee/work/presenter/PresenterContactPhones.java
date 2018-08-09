package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.iview.IContactPhonesView;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;
import com.blackcoffee.work.universal.cache.db.dao.impl.ISelfContactDaoImpl;

import java.util.List;

/**
 * Created by admin on 2018/5/30.
 * 类描述  手机联系人的contact
 * 版本
 */
public class PresenterContactPhones extends BasePresenter<IContactPhonesView> {


    private IContactPhonesView iContactPhonesView;

    private IBaseDao<SelfContact> iSelfContactDao;


    public PresenterContactPhones(IContactPhonesView iContactPhonesView) {
        this.iContactPhonesView = iContactPhonesView;
        this.iSelfContactDao = new ISelfContactDaoImpl();
    }


    public void doGetSelfContactFromDb() {


        List<SelfContact> selfContacts = iSelfContactDao.findAll(SelfContact.class);
        if(vertifyNotNull.isNotNullListSize(selfContacts)) {
            iContactPhonesView.doShowSelfContactFromDb(selfContacts);
        }else {

            iContactPhonesView.onVertifyErrorNoContacts();
        }


    }
}