package com.sias.MybatisTest;

import com.sias.Bean.User;
import com.sias.Dao.UserDao;
import com.sias.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Edgar
 * @create 2022-03-23 13:03
 * @faction:
 */
public class MybatisTest {


    /*1.查询全部的数据*/
    @Test
    public void GetAll(){
        /*1.因为这个方法是静态的，所以可以直接类点方法调用，里面的方法执行完了连接数据库的操作*/
        SqlSession session = MybatisUtils.getSession();
        /*2.把这个类加载进来*/
        UserDao mapper = session.getMapper(UserDao.class);
        /*3.加载进来之后就可以使用里面的方法，最后在找到配置文件*/
        List<User> all = mapper.getAll();
        for (User user : all) {
            System.out.println(user);
        }
        session.close();
    }


    /*2.按照id来查询*/
    @Test
    @DisplayName("2.按照id来查询数据")
    public void GetById(){
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.GetById(4);
        System.out.println(user);
        session.close();
    }

    /*3.按照id来删除数据*/
    @Test
    @DisplayName("3.按照id来删除数据")
    public void delete(){
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        mapper.delete(4);
        System.out.println("这一行数据已经删除");
        /*01.删除数据的话，是改变数据库中的数据，需要提交事务*/
        session.commit();
        session.close();
    }

    /*4.按照id去修改一行数据*/
    @Test
    @DisplayName("4.按照id去修改数据")
    public void update(){
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        /*01.修改数据的话，是从idea中到数据库的，所以数据也是在idea中去写好的
        *    怎么去写数据，哪就是对象了，就是用一个对象去存放数据，设置数据*/
        int update = mapper.update(new User(3, "王五", "3"));
        System.out.println(update);
    }
}
