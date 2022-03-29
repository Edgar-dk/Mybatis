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
        /*1.在一个实例化好的对象去调用一个方法的时候，
        *   需要理解这个方法的构造的方式，就是这个方法的组成结构
        *   首先，这个方法组成的话，可以有一个返回值，可以没有
        *   所谓的返回值是什么，是这个方法执行完产生的结果，这个结果是按照这个方法
        *   规定的类型产生的（返回的），这个为什么要产生这个结果呢，
        *   还是有原因的，首先，这个方法执行的话，不可能什么都不做
        *   那么既然做了，就要有结果，所以方法的类型就有了，就是
        *   为了给这个结果来规定的类型，调用这方的另外一个东西，就会
        *   得到这个方法产生的结果，哪这个结果你可以输出到控制台，
        *   也可以到其他的地方去运行（结果是按照方法的类型来的），去和
        *   其他的方法中的数据产生运算，这样又出现了结果，然后循环下去，所以
        *   就有了成千上完个结果，这个很多的结构构成了动态型的效果
        *   所以，就可能在前台的页面上点击一个按钮，去执行一个方法，产生的
        *   哪一个结果，可能会产生蝴蝶效应，会有成千上万个结果，随之而然的
        *   就构成了互联网上的动态型的效果，*/
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


    @Test
    public void Text() {
        SqlSession session = MybatisUtils.getSession();
//        session.getMapper(f)
        return;
    }
}
