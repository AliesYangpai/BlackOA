package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.IBusinessTripView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  出差申请的presenter
 * 版本
 */
public class PresenterBusinessTrip extends BasePresenter<IBusinessTripView> {


    private IBusinessTripView iBusinessTripView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterBusinessTrip(IBusinessTripView iBusinessTripView) {
        this.iBusinessTripView = iBusinessTripView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iBusinessTripView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iBusinessTripView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iBusinessTripView.doIsAddFile();
            } else {
                iBusinessTripView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iBusinessTripView.doIsAddApprover();
            } else {
                iBusinessTripView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iBusinessTripView.doIsAddCopyTo();
            } else {
                iBusinessTripView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}