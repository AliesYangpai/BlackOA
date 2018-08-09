package com.blackcoffee.work.presenter;

import com.blackcoffee.work.ui.BaseFragment;
import com.blackcoffee.work.ui.iview.IQRCodeIdentifyCardView;

/**
 * Created by admin on 2018/6/1.
 * 类描述   二维码名片的view
 * 版本
 */
public class PresenterQRCodeIdentifyCard extends BasePresenter<IQRCodeIdentifyCardView> {

    private IQRCodeIdentifyCardView iqrCodeIdentifyCardView;

    public PresenterQRCodeIdentifyCard(IQRCodeIdentifyCardView iqrCodeIdentifyCardView) {
        this.iqrCodeIdentifyCardView = iqrCodeIdentifyCardView;
    }


    


}