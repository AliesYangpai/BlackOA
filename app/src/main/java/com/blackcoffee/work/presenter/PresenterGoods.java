package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.IGoodsView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  请假的presenter
 * 版本
 */
public class PresenterGoods extends BasePresenter<IGoodsView> {


    private IGoodsView iGoodsView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterGoods(IGoodsView iGoodsView) {
        this.iGoodsView = iGoodsView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iGoodsView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iGoodsView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iGoodsView.doIsAddFile();
            } else {
                iGoodsView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iGoodsView.doIsAddApprover();
            } else {
                iGoodsView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iGoodsView.doIsAddCopyTo();
            } else {
                iGoodsView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}