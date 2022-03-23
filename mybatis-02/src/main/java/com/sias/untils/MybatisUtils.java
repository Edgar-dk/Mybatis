package com.sias.untils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Edgar
 * @create 2022-03-23 12:30
 * @faction:
 */

/*这个是一个工厂对象和原先的JDBC的模式不一样，这个是想创建好工厂之后，再去在这个工厂中去生产对象，然后根据创建好的对象
* 去操作数据库，这个创建好的对象，可以不放在这个地方，可以把这个对象，注入到其他的类中，然后在使用这个对象的方法*/
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            /*第一步，获取sqlSessionFactory这个对象，就是先创建好工厂，创建的时候，顺便
            *      加载连接数据的配置文件*/
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession连接，用创建好的工厂去创建一个对象（有了工厂才有产品）
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
