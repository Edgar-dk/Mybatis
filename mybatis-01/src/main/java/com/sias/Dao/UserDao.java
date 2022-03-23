package com.sias.Dao;

import com.sias.Bean.User;

import java.util.List;

/**
 * @author Edgar
 * @create 2022-03-23 12:52
 * @faction:
 */
public interface UserDao {
    /*1.查询全部的数据*/
    public List<User> getAll();

    /*2.按照id来查询*/
    public User GetById(int id);

    /*3.按照Id来删除一样数据*/
    public void delete(int id);

    /*4.按照id来修改一行数据
    *   下面的是模板，具体的数据还是需要去创建一个对象之后，在去填写数据*/
    public int update(User user);
}
