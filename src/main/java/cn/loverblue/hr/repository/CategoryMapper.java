package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Category;
import cn.loverblue.hr.bean.CategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    @Delete({
        "delete from category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into category (id, name, ",
        "sid)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{sid,jdbcType=INTEGER})"
    })
    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    @Select({
        "select",
        "id, name, sid",
        "from category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.CategoryMapper.BaseResultMap")
    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update category",
        "set name = #{name,jdbcType=VARCHAR},",
          "sid = #{sid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}