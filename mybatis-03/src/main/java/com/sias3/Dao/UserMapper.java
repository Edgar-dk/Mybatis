package com.sias3.Dao;


import com.sias3.Bean.User;
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

    /*4.往数据库中增加数据
     *   按照User的形式去返回数据，那么接受的时候也是全部的形式*/
    @Insert("insert into su(id,name,pwd) values(#{id},#{name},#{pwd})")
    public int AddUser(User user);

    /*5.修改用户的信息*/
    @Update("update su set name=#{name} ,pwd=#{pwd} where id=#{id}")
    public int update(User user);

}
