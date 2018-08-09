package com.blackcoffee.work.ui.iview;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.IBaseUploadPermissionView;

/**
 * Created by admin on 2018/6/7.
 * 类描述  物品领用的view
 * 版本
 */
public interface IGoodsView extends IBaseUploadPermissionView {


    void doIsAddFile();

    void doIsAddApprover();

    void doIsAddCopyTo();

    void doIsDelFile(FileAdd fileAdd);

    void doIsDelApprover(FileAdd fileAdd);

    void doIsDelCopyTo(FileAdd fileAdd);
}