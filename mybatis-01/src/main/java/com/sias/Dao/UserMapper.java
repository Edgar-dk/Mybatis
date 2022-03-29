package com.sias.Dao;

import com.sias.Bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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


    /*3.按照Id来删除一样数据*/
    public void delete(int id);

    /*4.按照id来修改一行数据
    *   下面的是模板，具体的数据还是需要去创建一个对象之后，在去填写数据*/
    public int update(User user);

    /*5.增加数据*/
    public int insert(User user);
    /*05.Map的方式去增加用户数据*/
    public int insert2(Map map);



    /*6.模糊查询*/
    public List<User> GetListLike(String name);


    /*1.按照id去查询用户*/
    @Select("select * from su where id=#{id}")
    public User GetByID(@Param("id") int id);
}
