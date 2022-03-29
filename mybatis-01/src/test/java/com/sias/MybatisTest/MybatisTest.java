package com.sias.MybatisTest;

import com.sias.Bean.User;
import com.sias.Dao.UserMapper;
import com.sias.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
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
        UserMapper mapper = session.getMapper(UserMapper.class);
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
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.GetById(4);
        System.out.println(user);
        session.close();
    }
    /*02.Map的形式去按照id查询
    *    返回过来的是对象的形式*/
    public void GerById2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userid",1);
        User user = mapper.GetById2(map);
        /*在GetById2这个方法中，返回值是一个对象
        * 只是按照这个对象来返回的，返回的时候，可以去接收
        * 这个数据就是在这个返回值中，一输出就展示在控制台上*/
        System.out.println(user);
        System.out.println("执行成功");
        session.close();

    }

    /*3.按照id来删除数据*/
    @Test
    @DisplayName("3.按照id来删除数据")
    public void delete(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
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
        UserMapper mapper = session.getMapper(UserMapper.class);
        /*01.修改数据的话，是从idea中到数据库的，所以数据也是在idea中去写好的
        *    怎么去写数据，哪就是对象了，就是用一个对象去存放数据，设置数据*/
        int update = mapper.update(new User(3, "王五", "3"));
        System.out.println(update);
        session.close();
    }


    /*5.增加用户数据*/
    @Test
    @DisplayName("5.增加用户数据")
    public void insert(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int insert = mapper.insert(new User(4, "扇子", "010101010"));
        System.out.println("执行插入的形式成功");
        System.out.println(insert);
        /*01.注意：什么使用去提交数据，之后当数据库中的数据大范围的改变的时候，才可以去提交数据*/
        session.commit();
        session.close();
    }

    /*05.Map的方式去增加数据*/
    @Test
    @DisplayName("05.map的方式增加数据")
    public void insert2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("userid",6);
        map.put("username","找刘");
        map.put("userpwd","23");
        int i = mapper.insert2(map);
        System.out.println(i);
        session.commit();
        session.close();
    }



    /*6.模糊查询*/
    @Test
    @DisplayName("6.模糊查询数据")
    public void GetListLike(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.GetListLike("%王%");
        for (User user : users) {
            System.out.println(users);
        }
        session.close();
    }












    /*1.按照id来查询数据*/
    @Test
    @DisplayName("1.按照id来查询数据")
    public void GetById2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.GetByID(11);
        System.out.println(user);
        session.close();
    }


}
