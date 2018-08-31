package com.example.designpattern.factorymethod;

/**
 * @author weipeng_yuan
 * @date 2018-08-25
 */
public abstract class Product {

    /**
     * 产品名称
     */
    private String name = "";

    /**
     * 产品价格
     */
    private String price = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
