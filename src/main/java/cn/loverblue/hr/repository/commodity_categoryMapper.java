package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Commodity_Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author PHY
 * @date 2020-10-23$-20:14
 */
@Mapper
public interface commodity_categoryMapper {


     Commodity_Category selectCateortid(@Param("sid") Integer sid);




}
