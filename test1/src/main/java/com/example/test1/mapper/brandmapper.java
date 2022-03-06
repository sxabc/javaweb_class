package com.example.test1.mapper;

import com.example.test1.entity.brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
public interface brandmapper {
    @Select("SELECT * FROM tb_brand ORDER BY ordered ")
    List<brand> selectAll();



    @Select("SELECT * FROM tb_brand WHERE id = #{id} ")
    brand selectById(int id);

    @Update("UPDATE tb_brand SET brandname = #{brandName},companyname = #{companyName},ordered = #{ordered},description = #{description},status = #{status} WHERE id = #{id} ")
    void update(brand brand);


    @Delete("DELETE FROM tb_brand WHERE id = #{id} ")
    void delete(String id);

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(brand brand);

}
