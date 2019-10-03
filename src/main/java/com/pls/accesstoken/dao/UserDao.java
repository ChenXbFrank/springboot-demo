package com.pls.accesstoken.dao;

import com.pls.accesstoken.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 81046 on 2018-08-02
 */
public interface UserDao {

    /**
     * 查询所有的用户信息
     * @return
     * //TODO 这种方式查不出对象的原因是没有将对象属性和表列名一一对应，导致最后查询出来映射不上来，结果就为空了
     * //TODO 解决方法：在mapper文件中实现并解决了该问题
     */
    @Select("select * from TB_USER")
    //TODO  解决了上面所述问题  越来越多的坑 嘻嘻
    @Results({
            @Result(property="id",column="ID"),
            @Result(property="name",column="NAME"),
            @Result(property="age",column="AGE")
    })
    List<User> getAllUserList();

    List<User> getUserListByName(@Param("name")String name);

    void updateUserByName(User user);

    void deleteUserById(@Param("id")String id);

    void insertUser(User user);
}
