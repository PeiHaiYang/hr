package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.ShoppingCar;
import cn.loverblue.hr.bean.ShoppingCarExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface ShoppingCarMapper {
    long countByExample(ShoppingCarExample example);

    int deleteByExample(ShoppingCarExample example);

    @Delete({
        "delete from shoppingcar",
        "where shop_car_id = #{shop_car_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shop_car_id);

    @Insert({
        "insert into shoppingcar (shop_car_id, pid, ",
        "uid, productnum, ",
        "productprice, address, ",
        "type)",
        "values (#{shop_car_id,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER}, ",
        "#{uid,jdbcType=INTEGER}, #{productnum,jdbcType=INTEGER}, ",
        "#{productprice,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR})"
    })
    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    List<ShoppingCar> selectByExample(ShoppingCarExample example);

    @Select({
        "select",
        "shop_car_id, pid, uid, productnum, productprice, address, type",
        "from shoppingcar",
        "where shop_car_id = #{shop_car_id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.ShoppingCarMapper.BaseResultMap")
    ShoppingCar selectByPrimaryKey(Integer shop_car_id);

    int updateByExampleSelective(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    int updateByExample(@Param("record") ShoppingCar record, @Param("example") ShoppingCarExample example);

    int updateByPrimaryKeySelective(ShoppingCar record);

    @Update({
        "update shoppingcar",
        "set pid = #{pid,jdbcType=INTEGER},",
          "uid = #{uid,jdbcType=INTEGER},",
          "productnum = #{productnum,jdbcType=INTEGER},",
          "productprice = #{productprice,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR}",
        "where shop_car_id = #{shop_car_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShoppingCar record);


    List<ShoppingCar> selectByType(@Param("uid") Integer uid);

}