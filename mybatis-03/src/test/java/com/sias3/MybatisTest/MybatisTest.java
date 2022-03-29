package com.sias3.MybatisTest;



import com.sias3.Bean.User;
import com.sias3.Dao.UserMapper;
import com.sias3.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Edgar
 * @create 2022-03-23 13:03
 * @faction:
 */
public class MybatisTest {

    /*1.按照id来查询数据*/
    @Test
    @DisplayName("1.按照id来查询数据")
    public void GetById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.GetByID(1);
        System.out.println(user);
        session.close();
    }


    /*2.查询全部的数据*/
    @Test
    @DisplayName("2.查询全部数据")
    public void GetAll(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.GetAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    /*3.按照id来删除数据*/
    @Test
    @DisplayName("3.按照id来删除数据")
    public void DeleteById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.DelectById(9);
        System.out.println("删除数据成功");
        session.close();
    }


    /*4.往数据库中增加数据*/
    @Test
    @DisplayName("4.插入数据")
    public void AddUserl(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.AddUser(new User(13, "站三你看书", "998"));
        System.out.println("成功的插入了数据");
        session.commit();
        session.close();

    }

    /*5.修改用户的信息*/
    @Test
    @DisplayName("5.修改用户的信息")
    public void update(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(11, "张三", "0");
        /*01.注意前面的放回值，是从数据库中放回数据用的，要不然的话，数据
        *    从哪里放回过来呢？*/
        int update = mapper.update(user);
        System.out.println(update);
        session.close();
    }
}
