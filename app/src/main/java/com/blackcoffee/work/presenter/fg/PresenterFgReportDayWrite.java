package com.blackcoffee.work.presenter.fg;

import com.blackcoffee.work.entity.temp.FileAdd;
import com.blackcoffee.work.presenter.BasePresenter;
import com.blackcoffee.work.ui.iview.fg.IFgReportDayWriteView;
import com.blackcoffee.work.universal.logic.view.LogicViewAdapter;
import com.blackcoffee.work.universal.logic.view.LogicViewRecycleView;

/**
 * Created by admin on 2018/5/29.
 * 类描述  写日报的presente
 * 版本
 */
public class PresenterFgReportDayWrite extends BasePresenter<IFgReportDayWriteView> {


    private IFgReportDayWriteView iFgReportDayWriteView;

    private LogicViewAdapter logicViewAdapter;
    private LogicViewRecycleView logicViewRecycleView;

    public PresenterFgReportDayWrite(IFgReportDayWriteView iFgReportDayWriteView) {
        this.iFgReportDayWriteView = iFgReportDayWriteView;
        this.logicViewRecycleView = new LogicViewRecycleView();
        this.logicViewAdapter = new LogicViewAdapter();
    }


    /**
     * 检查权限
     */
    public void doPermissionCheck(int requestCode, String... permissions) {

        iFgReportDayWriteView.doPermissionCheck(requestCode, permissions);

    }


    /**
     * 权限提示
     */
    public void doShowPermissionDialog() {

        iFgReportDayWriteView.doShowPermissionDialog();
    }


    public void doDealItemChildClick(String tag, Object o) {


        if (logicViewAdapter.isAddFilesAdapter(tag)) {
            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iFgReportDayWriteView.doIsAddFile();
            } else {
                iFgReportDayWriteView.doIsDelFile(fileAdd);
            }

            return;
        }


        if(logicViewAdapter.isAddApproverAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iFgReportDayWriteView.doIsAddApprover();
            } else {
                iFgReportDayWriteView.doIsDelApprover(fileAdd);
            }

            return;
        }



        if(logicViewAdapter.isAddCopyToAdapter(tag)) {

            FileAdd fileAdd = (FileAdd) o;

            String fileTag = fileAdd.getTag();
            if (logicViewRecycleView.isOperateAdd(fileTag)) {
                iFgReportDayWriteView.doIsAddCopyTo();
            } else {
                iFgReportDayWriteView.doIsDelCopyTo(fileAdd);
            }

            return;
        }


    }
}