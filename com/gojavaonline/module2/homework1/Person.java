package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public class Person {

    public Person(String name, String sname){
        this.name = name;
        this.sname = sname;
    }

    public Person(String name){
        this.name = name;
        this.sname = "";
    }

    @Override
    public String toString() {
        return "Person: {" +
                "\n\tFirst Name: '" + name + "'" +
                "\n\tSecond Name: '" + sname + "'" +
                "\n}";
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String sname;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}