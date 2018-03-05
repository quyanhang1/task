package com.imooc.dimain;



import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2018/3/4.
 */

@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "传入的为空值")
    private String cupSize;

    private Integer money;

    public Integer getMoney() {
        return money;
    }


    public void setMoney(Integer money) {
        this.money = money;
    }

    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;

    public Girl() {
    }

    public Girl(String cupSize, Integer money, Integer age) {
        this.cupSize = cupSize;
        this.money = money;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}
