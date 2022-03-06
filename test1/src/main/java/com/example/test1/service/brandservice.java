package com.example.test1.service;

import com.example.test1.entity.brand;
import com.example.test1.mapper.brandmapper;
import com.example.test1.util.sqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;
public class brandservice {
    SqlSessionFactory factory = sqlSessionFactoryUtil.getSqlSessionFactory();

    public List<brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        List<brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void update(brand brand) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    public void add(brand brand) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    public void delete(String id) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
    public brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }
}
