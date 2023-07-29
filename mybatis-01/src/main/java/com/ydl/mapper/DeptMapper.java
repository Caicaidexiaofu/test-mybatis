package com.ydl.mapper;

import com.ydl.entity.Dept;
import com.ydl.entity.Employee;

import java.util.List;

public interface DeptMapper {

    /**
     *
     * @param dept
     * @return
     */
    List<Dept> select(Dept dept);

    /**
     * 结果嵌套 连接查询
     * @param dept
     * @return
     */
    List<Dept> select2(Dept dept);

    /**
     *  查询嵌套 级联查询
     * @param dept
     * @return
     */
    List<Dept> selectAll(Dept dept);



}
