package com.ydl.mapper;

import com.ydl.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {


    /**
     * 注解开发
     * @return
     */
    @Select("select * from admin")
    List<Admin> selectAll();


    @Insert("insert into admin(id,username,password) values(#{id},#{username},#{password})")
    int saveAdmin(Admin admin);




}
