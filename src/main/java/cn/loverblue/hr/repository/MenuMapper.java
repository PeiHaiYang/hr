package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Menu;
import cn.loverblue.hr.bean.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into menu (id, name, ",
        "pid)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=INTEGER})"
    })
    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    @Select({
        "select",
        "id, name, pid",
        "from menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.MenuMapper.BaseResultMap")
    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set name = #{name,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}