package com.sias.Dao;

import com.sias.Bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Edgar
 * @create 2022-03-23 12:52
 * @faction:
 */
public interface UserMapper {
   /*1.按照id去查询用户*/
    @Select("select * from su where id=#{id}")
    public User GetByID(@Param("id") int id);

    /*2.查询全部的用户*/
    @Select("select * from su")
    public List<User> GetAll();

    /*3.按照id来删除用户的数据*/
    @Delete("delete from su where id=#{id}")
    public void DelectById(@Param("id") int id);

    /*4.往数据库中增加数据*/
    @Insert("insert into su(id,name,pwd) values(#{id},#{name},#{pwd})")
    public User AddUser(User user);

}
