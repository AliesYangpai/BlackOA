package com.blackcoffee.work.universal.function;

import com.blackcoffee.work.constant.ConstHz;
import com.blackcoffee.work.constant.ConstSign;
import com.blackcoffee.work.universal.logic.LogicName;

/**
 * Created by admin on 2018/5/31.
 * 类描述
 * 版本
 */
public class FunctionText {

    private LogicName logicName;

    public FunctionText() {

        this.logicName = new LogicName();
    }


    /**
     * 获取目标名称
     * @param name
     * @return
     */
    public String getTargetName(String name) {


        String target = ConstSign.DOUBLE_QUOTE;

        if (logicName.is1WordName(name)) {

            target = name;
        }

        if (logicName.is2WordName(name)) {

            target = name;
        }

        if (logicName.is3WordName(name)) {

            target = name.substring(1);

        }

        if(logicName.is4WordName(name)) {

            target = name.substring(2);
        }

        if(logicName.is4BeyondWordName(name)) {

            target = name.substring(name.length() - 2);

        }

        return target;

    }
}