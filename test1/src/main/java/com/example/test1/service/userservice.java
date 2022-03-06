package com.example.test1.service;

import com.example.test1.entity.user;
import com.example.test1.mapper.usermapper;
import com.example.test1.util.sqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class userservice {

    SqlSessionFactory factory = sqlSessionFactoryUtil.getSqlSessionFactory();
    public user login(String username, String password){
        SqlSession sqlSession = factory.openSession();
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        user user = mapper.findUser(username, password);
        sqlSession.close();
        return user;
    }
    public boolean register(user user) {
        SqlSession sqlSession = factory.openSession();
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        user u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }
}
