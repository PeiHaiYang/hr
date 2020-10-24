package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Power;
import cn.loverblue.hr.bean.PowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PowerMapper {
    long countByExample(PowerExample example);

    int deleteByExample(PowerExample example);

    @Delete({
        "delete from power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into power (id, uid, ",
        "mid)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{mid,jdbcType=INTEGER})"
    })
    int insert(Power record);

    int insertSelective(Power record);

    List<Power> selectByExample(PowerExample example);

    @Select({
        "select",
        "id, uid, mid",
        "from power",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.PowerMapper.BaseResultMap")
    Power selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByExample(@Param("record") Power record, @Param("example") PowerExample example);

    int updateByPrimaryKeySelective(Power record);

    @Update({
        "update power",
        "set uid = #{uid,jdbcType=INTEGER},",
          "mid = #{mid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Power record);
}