package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PHY
 * @date 2020-09-23$-21:41
 */

@Mapper
public interface DeptMapper {

    @Select("select * from dept")

    public List<Dept> findAll();

    public  List<Dept> selectById(@Param("id") Integer id);

}
