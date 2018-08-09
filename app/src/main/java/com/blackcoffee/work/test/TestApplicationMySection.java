package com.blackcoffee.work.test;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by admin on 2018/5/21.
 * 类描述  测试设置的section
 * 版本
 */
public class TestApplicationMySection extends SectionEntity<TestApplication> {
    private boolean isMore;



    public TestApplicationMySection(boolean isHeader, String header) {
        super(isHeader, header);
    }


    public TestApplicationMySection(TestApplication t) {
        super(t);
    }



}