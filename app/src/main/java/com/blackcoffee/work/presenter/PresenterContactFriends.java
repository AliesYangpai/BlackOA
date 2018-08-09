package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.iview.IContactFriendsView;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;
import com.blackcoffee.work.universal.cache.db.dao.impl.ISelfContactDaoImpl;

import java.util.List;

/**
 * Created by admin on 2018/5/31.
 * 类描述  我的好友列表界面
 * 版本
 */
public class PresenterContactFriends extends BasePresenter<IContactFriendsView> {

    private IContactFriendsView iContactFriendsView;



    private IBaseDao<SelfContact> iSelfContactDao;
    public PresenterContactFriends(IContactFriendsView iContactFriendsView) {
        this.iContactFriendsView = iContactFriendsView;
        this.iSelfContactDao = new ISelfContactDaoImpl();
    }


    public void doGetSelfContactFromDb() {


        List<SelfContact> selfContacts = iSelfContactDao.findAll(SelfContact.class);
        if(vertifyNotNull.isNotNullListSize(selfContacts)) {
            iContactFriendsView.doShowSelfContactFromDb(selfContacts);
        }else {

            iContactFriendsView.onVertifyErrorNoContacts();
        }


    }
}