package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Tag;
import cn.loverblue.hr.bean.TagExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    @Delete({
        "delete from tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tag (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    @Select({
        "select",
        "id, name",
        "from tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.TagMapper.BaseResultMap")
    Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    @Update({
        "update tag",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tag record);
}