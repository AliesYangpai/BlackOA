package com.blackcoffee.work.presenter;

import com.blackcoffee.work.constant.ConstSp;
import com.blackcoffee.work.entity.SelfContact;
import com.blackcoffee.work.ui.iview.IFirstEnterView;
import com.blackcoffee.work.universal.cache.db.dao.IBaseDao;
import com.blackcoffee.work.universal.cache.db.dao.impl.ISelfContactDaoImpl;
import com.blackcoffee.work.universal.cache.sp.SpUtil;

import java.util.List;

/**
 * Created by admin on 2018/5/4.
 * 类描述  首页的presenter
 * 版本
 */
public class PresenterFirstEnter extends BasePresenter<IFirstEnterView> {


    private IFirstEnterView iFirstEnterView;


    private IBaseDao<SelfContact> iSelfContactDao;


    public PresenterFirstEnter(IFirstEnterView iFirstEnterView) {
        this.iFirstEnterView = iFirstEnterView;
        this.iSelfContactDao = new ISelfContactDaoImpl();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iFirstEnterView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iFirstEnterView.doShowPermissionDialog();
    }

    public void doGoToMainOrWelCome() {


        boolean loadOrNot = SpUtil.getInstance().getBoolenValue(ConstSp.SP_KEY_LOAD_OR_NOT, false);


        if (loadOrNot) {

            iFirstEnterView.doGoToMain();

        } else {
            iFirstEnterView.doGoToWelcome();

        }

    }


    /**
     * 获取手机联系人类表
     */
    public void doGetContact() {

        List<SelfContact> selfContacts = iSelfContactDao.findAll(SelfContact.class);

        if (vertifyNotNull.isNotNullListSize(selfContacts)) {
            iSelfContactDao.deleteAll(SelfContact.class);
        }

        iFirstEnterView.doGetPhoneConTact();
    }


    /**
     * 保存系统联系人
     * @param selfContacts
     */
    public void doSaveContact(List<SelfContact> selfContacts) {
        iSelfContactDao.saveAll(selfContacts);

    }


}