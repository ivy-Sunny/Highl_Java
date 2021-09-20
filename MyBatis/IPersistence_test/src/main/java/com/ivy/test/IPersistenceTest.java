package com.ivy.test;

import com.ivy.io.Resources;
import com.ivy.pojo.User;
import com.ivy.sqlSession.SqlSession;
import com.ivy.sqlSession.SqlSessionFactory;
import com.ivy.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class IPersistenceTest {
    public void test() throws DocumentException, PropertyVetoException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        sqlSession.selectOne("user.selectOne", user);
    }
}
