package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Address;
import cn.loverblue.hr.bean.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    @Delete({
        "delete from address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into address (id, addr, ",
        "uid)",
        "values (#{id,jdbcType=INTEGER}, #{addr,jdbcType=VARCHAR}, ",
        "#{uid,jdbcType=INTEGER})"
    })
    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    @Select({
        "select",
        "id, addr, uid",
        "from address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.AddressMapper.BaseResultMap")
    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    @Update({
        "update address",
        "set addr = #{addr,jdbcType=VARCHAR},",
          "uid = #{uid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address record);
}