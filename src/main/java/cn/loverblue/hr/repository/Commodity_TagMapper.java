package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Commodity_Tag;
import cn.loverblue.hr.bean.Commodity_TagExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface Commodity_TagMapper {
    long countByExample(Commodity_TagExample example);

    int deleteByExample(Commodity_TagExample example);

    @Delete({
        "delete from commodity_tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into commodity_tag (id, commodity_id, ",
        "tag_id)",
        "values (#{id,jdbcType=INTEGER}, #{commodity_id,jdbcType=INTEGER}, ",
        "#{tag_id,jdbcType=INTEGER})"
    })
    int insert(Commodity_Tag record);

    int insertSelective(Commodity_Tag record);

    List<Commodity_Tag> selectByExample(Commodity_TagExample example);

    @Select({
        "select",
        "id, commodity_id, tag_id",
        "from commodity_tag",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.Commodity_TagMapper.BaseResultMap")
    Commodity_Tag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commodity_Tag record, @Param("example") Commodity_TagExample example);

    int updateByExample(@Param("record") Commodity_Tag record, @Param("example") Commodity_TagExample example);

    int updateByPrimaryKeySelective(Commodity_Tag record);

    @Update({
        "update commodity_tag",
        "set commodity_id = #{commodity_id,jdbcType=INTEGER},",
          "tag_id = #{tag_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Commodity_Tag record);
}