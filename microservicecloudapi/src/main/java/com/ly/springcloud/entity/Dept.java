package com.ly.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor//全参的构造方法
@NoArgsConstructor//空参的构造方法
@Data//get、set方法
@Accessors(chain = true) //链式访问方法
public class Dept implements Serializable{

    private Long deptno;

    private String dname;

    private String db_source;


    public void setDname(String dname) {
        this.dname = dname;
    }
}
