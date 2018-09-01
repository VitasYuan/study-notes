package com.example.designpattern.prototype;

/**
 * @author weipeng_yuan
 * @date 2018-09-01
 */
public class ConcretePrototype implements Cloneable {

    private int id;

    private String name;

    public ConcretePrototype() {
        System.out.println("ConcretePrototype construct.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype concretePrototype = null;
        try {
            concretePrototype = (ConcretePrototype) super.clone();
        } catch (Exception e) {

        }
        return concretePrototype;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
