package com.example.test4.service;

import com.example.test4.entity.brand;
import com.example.test4.entity.PageBean;

import java.util.List;

public interface BrandService {
    List<brand> selectAll();

    void add( brand brand);

    void deleteByIds(int[] ids);

    PageBean<brand> selectByPage(int currentPage, int pageSize);

    PageBean<brand> selectByPageAndCondition(int currentPage, int pageSize, brand brand ) ;

}
