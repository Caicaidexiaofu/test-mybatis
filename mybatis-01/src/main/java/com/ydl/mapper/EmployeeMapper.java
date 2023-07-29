package com.ydl.mapper;

import com.ydl.entity.Employee;


import java.util.List;

public interface EmployeeMapper {

    /**
     * 多条件查询
     * @param employee
     * @return
     */
    List<Employee> select(Employee employee );


    List<Employee> select2(Employee employee );


}
