package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Details;
import cn.loverblue.hr.bean.DetailsExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DetailsMapper {
    long countByExample(DetailsExample example);

    int deleteByExample(DetailsExample example);

    @Delete({
        "delete from details",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into details (id, describe, ",
        "sid)",
        "values (#{id,jdbcType=INTEGER}, #{describe,jdbcType=VARCHAR}, ",
        "#{sid,jdbcType=INTEGER})"
    })
    int insert(Details record);

    int insertSelective(Details record);

    List<Details> selectByExample(DetailsExample example);

    @Select({
        "select",
        "id, describe, sid",
        "from details",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.DetailsMapper.BaseResultMap")
    Details selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Details record, @Param("example") DetailsExample example);

    int updateByExample(@Param("record") Details record, @Param("example") DetailsExample example);

    int updateByPrimaryKeySelective(Details record);

    @Update({
        "update details",
        "set describe = #{describe,jdbcType=VARCHAR},",
          "sid = #{sid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Details record);
}