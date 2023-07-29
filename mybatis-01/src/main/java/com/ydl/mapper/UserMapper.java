package com.ydl.mapper;

import com.ydl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();


    /**
     * 通过 id 查询用户
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 两个参数 查询
     * @param username
     * @param password
     * @return
     */
    User selects(@Param("username") String username, @Param("password") String password);


    /**
     * 对象作为参数
     * @param user
     * @return
     */
    List<User> selectByUser(User user);

    /**
     * Map 作为参数
     * @param map
     * @return
     */
    User selectByMap(Map<String,Object> map);

    /**
     * 模糊查询
     * @param param
     * @return
     */
    List<User> selectObscure(String param);


    /**
     *  插入一条记录
     * @return
     */
    int insert(User user);


    /**
     *
     * @param user
     * @return
     */
    int update(User user);


    /**
     *
     * @param id
     * @return
     */
    int delete(int id);


    /**
     * 根据id批量删除元素
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") List<Integer> ids);


    /**
     * 批量插入
     * @param users
     * @return
     */
    int batchInsert(@Param("users") List<User> users);


}
