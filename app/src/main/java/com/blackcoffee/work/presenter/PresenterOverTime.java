package com.blackcoffee.work.presenter;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.ui.iview.IOverTimeView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  加班的Presenter
 * 版本
 */
public class PresenterOverTime extends BasePresenter<IOverTimeView> {


    private IOverTimeView iOverTimeView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterOverTime(IOverTimeView iOverTimeView) {
        this.iOverTimeView = iOverTimeView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iOverTimeView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iOverTimeView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iOverTimeView.doIsAddFile();
            } else {
                iOverTimeView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iOverTimeView.doIsAddApprover();
            } else {
                iOverTimeView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iOverTimeView.doIsAddCopyTo();
            } else {
                iOverTimeView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}