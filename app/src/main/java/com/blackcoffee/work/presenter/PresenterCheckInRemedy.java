package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.ICheckInRemedyView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  补卡的presenter
 * 版本
 */
public class PresenterCheckInRemedy extends BasePresenter<ICheckInRemedyView> {


    private ICheckInRemedyView iCheckInRemedyView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterCheckInRemedy(ICheckInRemedyView iCheckInRemedyView) {
        this.iCheckInRemedyView = iCheckInRemedyView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iCheckInRemedyView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iCheckInRemedyView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iCheckInRemedyView.doIsAddFile();
            } else {
                iCheckInRemedyView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iCheckInRemedyView.doIsAddApprover();
            } else {
                iCheckInRemedyView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iCheckInRemedyView.doIsAddCopyTo();
            } else {
                iCheckInRemedyView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}