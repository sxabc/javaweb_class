package com.example.day2;

public class person {
    String name;
    Integer age;

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public person(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("我在猛吃。。。。");
    }
}
