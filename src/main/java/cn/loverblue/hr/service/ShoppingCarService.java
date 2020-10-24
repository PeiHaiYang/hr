package cn.loverblue.hr.service;

import cn.loverblue.hr.bean.*;
import cn.loverblue.hr.repository.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PHY
 * @date 2020-10-22$-9:55
 */

@Service
public class ShoppingCarService {

    @Resource
    ShoppingCarMapper shoppingCarMapper;

    @Resource
    CommodityMapper commodityMapper;

    @Resource
    NumMapper numMapper;

    @Resource
    commodity_categoryMapper commodity_categoryMapper;

    @Resource
    CategoryMapper categoryMapper;

    public List<ShoppingCar> findAll(Integer uid){

        return null;
    }

    public Map<String,Object> addShoppingCar(Integer uid, Integer sid,Integer addNum) {

        Commodity commodity = commodityMapper.commoditydetail(sid);
        ShoppingCar shoppingCar = new ShoppingCar();

        Map<String ,Object> map = new HashMap<>();
        /*
         * 判断库存
         *
         */
        if(commodity.getNum().getNumber()>0&&addNum<commodity.getNum().getNumber()){

            map.put("num","库存充足");

            List<ShoppingCar> shoppingCarList = shoppingCarMapper.selectByType(uid);
            for (int i = 0; i < shoppingCarList.size(); i++) {
                ShoppingCar shoppingCar1 = shoppingCarList.get(i);
                if (shoppingCar1.getPid()==sid) {

                    shoppingCar.setProductnum(addNum+shoppingCar1.getProductnum());

                }else {
                    shoppingCar.setProductnum(addNum);
                }
            }

            shoppingCar.setPid(sid);

            shoppingCar.setUid(uid);

            shoppingCar.setType(""+commodity_categoryMapper.selectCateortid(commodity.getId()).getCategory_id());

            double price = shoppingCar.getProductnum()*commodity.getPrice();

            shoppingCar.setProductprice(String.valueOf(price));

            if(shoppingCarMapper.insert(shoppingCar)==1){

               Goods goods  = new Goods();

               goods.setId(sid);
               goods.setImgUrl(commodity.getPic());
               goods.setName(commodity.getName());
               goods.setUpperLimit(commodity.getNum().getNumber());
               goods.setPrice(price);
               goods.setSelectNum(addNum);
               goods.setSelected(true);
               goods.setTips(commodity.getDetails().getDescribe());

               map.put("good",goods);

               return map;
            }
        }else{
            map.put("num","库存不足");
            return map;
        }
        return map;
    }
        /*
        * 这个是查询某用户的购物车所有信息
        *
        * */
     public List<GoodsInfo> queryShoppingCar (Integer uid){

         List<ShoppingCar> carList = shoppingCarMapper.selectByType(uid);

         List<GoodsInfo>  goodsInfoList = new ArrayList<>();

         List<Goods> goodsList = null;

         int flag = 0 ;
         for (int i = 0; i < carList.size(); i++) {

             ShoppingCar car = carList.get(i);
             System.out.println(car);
             Commodity_Category commodity_category = commodity_categoryMapper.selectCateortid(car.getPid());
             System.out.println(commodity_category);
             Commodity commodity = commodityMapper.commoditydetail(car.getPid());
             System.out.println(commodity);

             GoodsInfo goodsInfo = new GoodsInfo();

             Goods goods = new Goods();

             goods.setId(car.getPid());
             goods.setImgUrl(commodity.getPic());
             goods.setName(commodity.getName());
             goods.setUpperLimit(commodity.getNum().getNumber());
             goods.setPrice(Double.parseDouble(car.getProductprice()));
             goods.setSelectNum(car.getProductnum());
             goods.setSelected(true);
             goods.setTips(commodity.getDetails().getDescribe());

             if(flag==0){
                 goodsList =  new ArrayList<>();
                 flag = 1;
                 goodsInfo.setCategory(categoryMapper.selectByPrimaryKey(commodity_category.getCategory_id()).getName());
                 goodsInfo.setKey(""+commodity_category.getCategory_id());
                 goodsList.add(goods);
                 goodsInfo.setGoods(goodsList);
                 goodsInfoList.add(goodsInfo);
             }
             if(flag==1){
                 flag = commodity_category.getCategory_id();
             }else {
                 if( flag == commodity_category.getCategory_id()){
                     goodsList.add(goods);
                 }else {
                     goodsList =  new ArrayList<>();
                     goodsInfo.setCategory(categoryMapper.selectByPrimaryKey(commodity_category.getCategory_id()).getName());
                     goodsInfo.setKey(""+commodity_category.getCategory_id());
                     goodsList.add(goods);
                     goodsInfo.setGoods(goodsList);
                     goodsInfoList.add(goodsInfo);
                     flag = commodity_category.getCategory_id();
                 }
             }



         }

         return goodsInfoList;

    }


}
