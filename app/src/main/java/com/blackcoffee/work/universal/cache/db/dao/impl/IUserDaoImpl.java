package com.blackcoffee.work.universal.cache.db.dao.impl;



import com.blackcoffee.work.entity.User;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;
import com.google.gson.internal.bind.DateTypeAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Alie on 2017/11/6.
 * 类描述   用户实现类
 * 版本
 */

public class IUserDaoImpl implements IBaseDao<User> {


    @Override
    public boolean save(User user) {

        return user.save();
    }

    @Override
    public void saveAll(List<User> users) {
        DataSupport.saveAll(users);
    }


    @Override
    public int deleteAll(Class<User> userClass) {
        return DataSupport.deleteAll(userClass);
    }

    @Override
    public int deleteAllByCondition(Class<User> userClass, String... args) {
        return DataSupport.deleteAll(userClass, args);
    }


    @Override
    public List<User> findAll(Class<User> userClass) {

        return DataSupport.findAll(userClass);
    }

    @Override
    public User findFirst(Class<User> userClass) {

        return DataSupport.findFirst(userClass);
    }

    @Override
    public List<User> findByCondition(Class<User> userClass, String... args) {
        return DataSupport.where(args).find(userClass);
    }
}
