package cn.loverblue.hr.service;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.bean.CommodityExample;
import cn.loverblue.hr.bean.ImgNameAndPath;
import cn.loverblue.hr.repository.CommodityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PHY
 * @date 2020-10-15$-10:27
 */
@Service
public class CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    /*主页按销量显示九个商品*/
    public List<Commodity> sellWell(){

        return commodityMapper.sellWell();
    }

    /*显示主页的类别*/
    public List<ImgNameAndPath> sort(){
        return commodityMapper.sort();
    }

    /*主页按清仓显示五个商品*/
    public List<Commodity> selectBad(){
        return commodityMapper.sellBad();
    }

    /*将前端的主页信息进行动态初始化加载*/
    public List<Commodity> initializeIndex(){

        CommodityExample commodityExample = new CommodityExample();

        CommodityExample.Criteria criteria = commodityExample.createCriteria();

        return commodityMapper.selectByExample(commodityExample);
    }
    /*二级分类 主页下的分类方法*/
    public List<Commodity> selectSort(String category_id) {


        return commodityMapper.selectSort(category_id);
    }
    /*主页在导航栏点击更多产品，查询出所有产品*/
    public PageInfo<Commodity> selectAll(Integer pageNum,Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);

        List<Commodity> list = commodityMapper.selectall();

        return new PageInfo<Commodity> (list);
    }
    /*商品的分页操作*/
    public PageInfo<Commodity> findByPage(int pageNum, int pageSize,String category_id){

        PageHelper.startPage(pageNum, pageSize);

        List<Commodity> list = commodityMapper.selectSort(category_id);

        return new PageInfo<Commodity>(list);
    }
    /*主页按销量的商品详情*/
    public Commodity commodityDetail(Integer id){

        return commodityMapper.commoditydetail(id);
    }
    /*商品详情页当前分类下的除当前商品以外的其他商品*/
    public List<Commodity> relateBySort(Integer id){
        return commodityMapper.relateBySort(id);
    }

    /*多条件组合查询*/
    public PageInfo<Commodity> findOrderByPage(int pageNum, int pageSize,
                                               String category_id,String orderByPrice,String orderByBrand){

        PageHelper.startPage(pageNum, pageSize);

        List<Commodity> list = commodityMapper.orderByPage(category_id, orderByPrice, orderByBrand);

        return new PageInfo<Commodity>(list);
    }



}
