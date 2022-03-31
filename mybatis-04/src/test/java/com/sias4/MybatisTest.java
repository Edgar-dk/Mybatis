package com.sias4;

import com.sias4.Dao.StudentMapper;
import com.sias4.entity.Student;
import com.sias4.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Edgar
 * @create 2022-03-31 14:29
 * @faction:
 */
public class MybatisTest {



    @Test
    @DisplayName("查询全部的数据")
    public void GetAll(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.GetAll();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}
