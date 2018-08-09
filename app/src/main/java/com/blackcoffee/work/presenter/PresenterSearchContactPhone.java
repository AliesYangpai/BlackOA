package com.blackcoffee.work.presenter;

import android.widget.ListView;

import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.iview.ISearchContactPhoneView;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;
import com.blackcoffee.work.universal.cache.db.dao.impl.ISelfContactDaoImpl;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by admin on 2018/5/31.
 * 类描述  搜索界面： 对应手机联系人
 * 版本
 */
public class PresenterSearchContactPhone extends BasePresenter<ISearchContactPhoneView> {


    private ISearchContactPhoneView iSearchContactPhoneView;


    private IBaseDao<SelfContact> iSelfContactDao;

    public PresenterSearchContactPhone(ISearchContactPhoneView iSearchContactPhoneView) {
        this.iSearchContactPhoneView = iSearchContactPhoneView;
        this.iSelfContactDao = new ISelfContactDaoImpl();
    }


    /**
     * 开始执行查询
     * @param condition
     */
    public void doSearch(String arg,String... condition) {



        if(vertifyNotNull.isNullString(arg)) {

            iSearchContactPhoneView.doSearchRecordsClear();

        }else {

            List<SelfContact> selfContacts = iSelfContactDao.findByCondition(SelfContact.class, condition);

            iSearchContactPhoneView.onDataBackSuccessForContactPhoneSearch(selfContacts);
        }



    }
}