package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.ICheckInRemedyView;
import com.blackcoffee.work.ui.iview.ITakeBreakView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  请假的presenter
 * 版本
 */
public class PresenterTakeBreak extends BasePresenter<ITakeBreakView> {


    private ITakeBreakView iTakeBreakView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterTakeBreak(ITakeBreakView iTakeBreakView) {
        this.iTakeBreakView = iTakeBreakView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iTakeBreakView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iTakeBreakView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iTakeBreakView.doIsAddFile();
            } else {
                iTakeBreakView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iTakeBreakView.doIsAddApprover();
            } else {
                iTakeBreakView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iTakeBreakView.doIsAddCopyTo();
            } else {
                iTakeBreakView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}