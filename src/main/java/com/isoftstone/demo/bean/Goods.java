package com.isoftstone.demo.bean;

import java.io.Serializable;

public class Goods implements Serializable {
    private static final long serialVersionUID = -5309493386250996729L;
    private String name;
    private String size;
    private String image;

    public Goods() {
    }

    public Goods(String name, String size, String image) {
        this.name = name;
        this.size = size;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
