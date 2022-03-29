package com.sias.MybstisTest;


import com.sias.Bean.User;
import com.sias.Dao.UserMapper;
import com.sias.untils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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

    static Logger logger =Logger.getLogger(MybatisTest.class);


    /*2.按照id来查询*/
    @Test
    @DisplayName("2.按照id来查询数据")
    public void GetById(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.GetById(4);
        logger.info("这个是警告的信息11111111111111111111111111");
        System.out.println(user);
        session.close();
    }


    /*3.测试分页查询*/
    @Test
    @DisplayName("3.分页查询")
    public void limit(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("start",0);
        map.put("stop",2);
        List<User> limit = mapper.limit(map);
        for (User user : limit) {
            System.out.println(user);
        }
        session.close();
    }


}
