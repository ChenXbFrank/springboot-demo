package com.pls.accesstoken.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 81046 on 2018-07-20
 */
@Entity
@Table(name = "TB_USER")
public class User implements Serializable{
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
