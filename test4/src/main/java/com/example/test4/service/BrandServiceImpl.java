package com.example.test4.service;

import com.example.test4.entity.PageBean;
import com.example.test4.entity.brand;
import com.example.test4.mapper.brandmapper;
import com.example.test4.util.sqlSessionFactoryUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = sqlSessionFactoryUtil.getSqlSessionFactory();
    @Override
    public List<brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);//4.调用方法
        List<brand> brands = mapper.selectAll();//5．释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(brand brand) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds( int[] ids ) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
    @Override
    public PageBean<brand> selectByPage(int currentPage,int pageSize){
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession. getMapper(brandmapper.class ) ;
        int begin = ( currentPage - 1) * pageSize;
        List<brand> rows = mapper.selectByPage( begin,pageSize);
        int totalCount = mapper.selectTotalCount( );//封装PageBean对象
        PageBean<brand> pageBean = new PageBean<>( );pageBean.setRows( rows );
        pageBean . setTotalCount( totalCount ) ;sqlSession.close( );
        return pageBean;
    }

    @Override
    public PageBean<brand> selectByPageAndCondition(int currentPage,int pageSize,brand brand) {
        SqlSession sqlSession = factory.openSession();
        brandmapper mapper = sqlSession.getMapper(brandmapper.class);
        int begin = (currentPage - 1) * pageSize;
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }
        List<brand> rows = mapper.selectByPageAndCondition(begin, pageSize, brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);
        PageBean<brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

}