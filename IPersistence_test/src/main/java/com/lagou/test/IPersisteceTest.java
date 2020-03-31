package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlsession.SqlSession;
import com.lagou.sqlsession.SqlSessionFactory;
import com.lagou.sqlsession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersisteceTest {

    @Test
    public void  test1() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        System.out.println(resourceAsStream);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Object> objects = sqlSession.selectList("user.selectAll");
//        for (Object object : objects) {
//            System.out.println(object);
//        }

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //作业  更新操作
//        User user = new User();
//        user.setId(1);
//        user.setUsername("vvvvvvv");
//        Integer integer = mapper.editUsernameById(user);
//        System.out.println(integer);

    }
}
