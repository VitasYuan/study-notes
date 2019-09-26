package com.example.validator.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author weipeng_yuan
 * @date 2019-08-26 15:59
 */
public class Demo2 {

    @Length(min = 5, max = 17, message = "length长度在[5,17]之间")
    private String length;

    @Size(min = 1, max = 3, message = "size在[1,3]之间")
    private String age;

    @Range(min = 150, max = 250, message = "range在[150,250]之间")
    private int high;

    @Size(min = 3,max = 5,message = "list的Size在[3,5]")
    private List<String> list;

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

    public Demo2() {
    }
}
