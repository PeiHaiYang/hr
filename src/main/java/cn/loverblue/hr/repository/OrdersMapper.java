package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Orders;
import cn.loverblue.hr.bean.OrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, scid, ",
        "pid, uid, productnum, ",
        "type, state, joinTime)",
        "values (#{id,jdbcType=INTEGER}, #{scid,jdbcType=INTEGER}, ",
        "#{pid,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, #{productnum,jdbcType=INTEGER}, ",
        "#{type,jdbcType=VARCHAR}, #{state,jdbcType=INTEGER}, #{joinTime,jdbcType=TIMESTAMP})"
    })
    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    @Select({
        "select",
        "id, scid, pid, uid, productnum, type, state, joinTime",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.OrdersMapper.BaseResultMap")
    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    @Update({
        "update orders",
        "set scid = #{scid,jdbcType=INTEGER},",
          "pid = #{pid,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=INTEGER},",
          "productnum = #{productnum,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "joinTime = #{joinTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}