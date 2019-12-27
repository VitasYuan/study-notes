package com.example.validator.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author weipeng_yuan
 * @date 2019-08-26 15:59
 */
public class Demo2 extends ScriptTest{

//    @Length(min = 5, max = 17, message = "length长度在[5,17]之间")
    private String length;

//    @Size(min = 1, max = 3, message = "size在[1,3]之间")
    private String age;

//    @Range(min = 150, max = 250, message = "range在[150,250]之间")
    private int high;

//    @Size(min = 3, max = 5, message = "list的Size在[3,5]")
    private List<String> list;

    /**
     *
     */
    private String scriptTest;

    @Pattern(regexp = "[+-]?[0-9.]+$", message = "不为double")
    private String doubleValue;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Demo2(String length, String age, int high, List<String> list) {
        this.length = length;
        this.age = age;
        this.high = high;
        this.list = list;
    }

//    @ParameterScriptAssert(lang="javascript",
//            script="com.example.validator.model.checkParams(_this.name,_this.age,_this.classes)", message = "年龄错误")
//    public static boolean checkParams(String age, int high) {
//        System.out.println("age:" + age + ".high:" + high);
//        return false;
//    }


    public String getScriptTest() {
        return scriptTest;
    }

    public void setScriptTest(String scriptTest) {
        this.scriptTest = scriptTest;
    }

    public String getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(String doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Demo2() {
    }
}
