package com.sias.Dao;

import com.sias.Bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author Edgar
 * @create 2022-03-23 12:52
 * @faction:
 */
public interface UserMapper {
    /*1.查询全部的数据*/
    public List<User> getAll();

    /*2.按照id来查询*/
    public User GetById(int id);
    /*02.Map的形式按照id去查询
    *    返回值是对象的形式，因为过来是数据是对象的形式*/
    public User GetById2(Map map);


    /*3.模糊查询*/
    public List<User> limit(Map map);
}
