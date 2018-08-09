package com.blackcoffee.work.universal.cache.db.dao;

import android.widget.ListView;

import java.util.List;

/**
 * Created by Alie on 2017/11/6.
 * 类描述 本地数据库查询接口
 * 版本
 */

public interface IBaseDao<T> {

    /**
     * 增(保存)
     */

    boolean save(T t);

    void saveAll(List<T> t);

    /**
     * 删除
     */
    int deleteAll(Class<T> tClass);

    int deleteAllByCondition(Class<T> tClass, String... args);

    /**
     * 查询
     */

    List<T> findAll(Class<T> tClass);

    T findFirst(Class<T> tClass);

    /**
     * 个根据条件查询
     * @param tClass
     * @param args
     * @return
     */
    List<T> findByCondition(Class<T> tClass,String...args);

    /**
     * 修改
     */


}
