package com.example.designpattern.template;

/**
 * @author weipeng_yuan
 * @date 2018-08-26
 */
public class WorkServiceImpl extends WorkAbstractService{

    public void workFlow1(){
        //签到-早会-需求讨论-午饭-开发-联调-修复bug
        sign();
        morningMeeting();
        requirementsDiscussion();
        eat();
        develop();
        debug();
        fixBug();
    }

    public void workFlow2(){
        //签到-需求讨论-开发-午饭-联调-修复bug
        sign();
        requirementsDiscussion();
        develop();
        eat();
        develop();
        fixBug();
    }

}
