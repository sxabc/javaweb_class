package com.example.test4.mapper;


import com.example.test4.entity.brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface brandmapper {
    @Select("SELECT * FROM tb_brand ORDER BY ordered ")
    List<brand> selectAll();



    @Select("SELECT * FROM tb_brand WHERE id = #{id} ")
    brand selectById(int id);



    @Update("UPDATE tb_brand SET brandname = #{brandName},companyname = #{companyName},ordered = #{ordered},description = #{description},status = #{status} WHERE id = #{id} ")
    void update(brand brand);






    @Select( "SELECT COUNT(*)FROM tb_brand " )
    int selectTotalCount( );

    @Select( "SELECT * FROM tb_brand LIMIT #{begin} , #{size} ")
    List<brand> selectByPage( @Param( " begin" ) int begin,@Param( "size" ) int size);

    void deleteByIds(@Param("ids") int[] ids);

    List<brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size, @Param("brand")  brand brand);

    int selectTotalCountByCondition(brand brand);

    @Delete("DELETE FROM tb_brand WHERE id = #{id} ")
    void delete(String id);






    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(brand brand);


}
