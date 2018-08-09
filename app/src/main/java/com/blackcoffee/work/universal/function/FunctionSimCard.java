package com.blackcoffee.work.universal.function;

import android.telephony.TelephonyManager;

/**
 * Created by admin on 2018/6/1.
 * 类描述
 * 版本
 */
public class FunctionSimCard {


    /**
     * 判断sim卡是否存在
     * @param simState
     * @return
     */
    public boolean isSimCardExist(int simState) {

        boolean result = true;
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                result = false; // 没有SIM卡
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                result = false;
                break;
        }
        return result;
    }
}