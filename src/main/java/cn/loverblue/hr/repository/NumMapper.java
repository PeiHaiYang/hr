package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Num;
import cn.loverblue.hr.bean.NumExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface NumMapper {
    long countByExample(NumExample example);

    int deleteByExample(NumExample example);

    @Delete({
        "delete from num",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into num (id, number, ",
        "sid)",
        "values (#{id,jdbcType=INTEGER}, #{number,jdbcType=INTEGER}, ",
        "#{sid,jdbcType=INTEGER})"
    })
    int insert(Num record);

    int insertSelective(Num record);

    List<Num> selectByExample(NumExample example);

    @Select({
        "select",
        "id, number, sid",
        "from num",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.NumMapper.BaseResultMap")
    Num selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Num record, @Param("example") NumExample example);

    int updateByExample(@Param("record") Num record, @Param("example") NumExample example);

    int updateByPrimaryKeySelective(Num record);

    @Update({
        "update num",
        "set number = #{number,jdbcType=INTEGER},",
          "sid = #{sid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Num record);
}