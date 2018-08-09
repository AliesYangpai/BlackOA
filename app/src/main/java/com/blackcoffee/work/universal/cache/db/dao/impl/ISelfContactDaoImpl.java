package com.blackcoffee.work.universal.cache.db.dao.impl;



import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.entity.User;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Alie on 2017/11/6.
 * 类描述   读取手机联系人的
 * 版本
 */

public class ISelfContactDaoImpl implements IBaseDao<SelfContact> {


    @Override
    public boolean save(SelfContact selfContact) {

        return selfContact.save();
    }

    @Override
    public void saveAll(List<SelfContact> selfContacts) {
        DataSupport.saveAll(selfContacts);
    }

    @Override
    public int deleteAll(Class<SelfContact> selfContact) {
        return DataSupport.deleteAll(selfContact);
    }

    @Override
    public int deleteAllByCondition(Class<SelfContact> selfContact, String... args) {
        return DataSupport.deleteAll(selfContact, args);
    }


    @Override
    public List<SelfContact> findAll(Class<SelfContact> selfContact) {

        return DataSupport.findAll(selfContact);
    }

    @Override
    public SelfContact findFirst(Class<SelfContact> selfContact) {

        return DataSupport.findFirst(selfContact);
    }

    @Override
    public List<SelfContact> findByCondition(Class<SelfContact> selfContact, String... args) {
        return DataSupport.where(args).find(selfContact);
    }
}
