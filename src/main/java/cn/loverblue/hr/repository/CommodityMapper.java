package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.bean.CommodityExample;
import java.util.List;

import cn.loverblue.hr.bean.ImgNameAndPath;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommodityMapper {
    long countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    @Delete({
        "delete from commodity",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into commodity (id, name, ",
        "price, brand, jointime, ",
        "tid, pic)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DOUBLE}, #{brand,jdbcType=VARCHAR}, #{jointime,jdbcType=TIMESTAMP}, ",
        "#{tid,jdbcType=INTEGER}, #{pic,jdbcType=VARCHAR})"
    })
    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);

    @Select({
        "select",
        "id, name, price, brand, jointime, tid, pic",
        "from commodity",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.CommodityMapper.BaseResultMap")
    Commodity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    @Update({
        "update commodity",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DOUBLE},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "jointime = #{jointime,jdbcType=TIMESTAMP},",
          "tid = #{tid,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Commodity record);
    /*主页按销量显示九个商品*/
    @Select({  "SELECT ",
            "*",
            "FROM commodity",
            "WHERE id in",
            "(SELECT commodity_id",
            "FROM commodity_tag",
            "WHERE tag_id=1)"})
    List<Commodity> sellWell();
    /*主页五个商品分类*/
    @Select({
            "SELECT category.`id` sortid,category.`name` sortname, allimg.imgname imgname",
            "FROM category,allimg",
            "where category.sid=allimg.id"
    })
    List<ImgNameAndPath> sort();
    /*主页按清仓显示五个商品*/
    @Select({"SELECT ",
            "*",
            "FROM commodity",
            "WHERE id in",
            "(SELECT commodity_id",
            "FROM commodity_tag",
            "WHERE tag_id=2)"})
    List<Commodity> sellBad();
    /*按主页的分类显示对应的商品*/
    @Select({
            "SELECT * from commodity",
            "WHERE commodity.id in",
            "(SELECT commodity_id FROM commodity_category WHERE category_id=#{category_id,jdbcType=INTEGER})"
    })
    List<Commodity> selectSort(@Param("category_id") String category_id);
    /*主页在导航栏点击更多产品，查询出所有产品*/
    @Select({
            "SELECT * from commodity"
    })
    List<Commodity> selectall();

    /*主页按销量的商品详情*/
    Commodity commoditydetail(@Param("id") Integer id);
    /*商品详情页当前分类下的除当前商品以外的其他商品*/
    @Select({
            "SELECT *",
            "FROM commodity",
            "WHERE id!=#{id,jdbcType=INTEGER}"
    })
    List<Commodity> relateBySort(@Param("id") Integer id);
    /*搜索*/

    List<Commodity> search(@Param("name") String name);

    List<Commodity> orderByPage(@Param("category_id") String category_id,@Param("orderByBrand") String orderByBrand,@Param("orderByPrice") String orderByPrice);
}