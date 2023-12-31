package com.ydl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {

    public static final Long serialVersionUID = 1L;

    private int id;
    private String name;

    private List<Employee> employees;

}
