package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Goods;
import cn.loverblue.hr.bean.GoodsInfo;
import cn.loverblue.hr.bean.ShoppingCar;
import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.repository.ShoppingCarMapper;
import cn.loverblue.hr.service.ShoppingCarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author PHY
 * @date 2020-10-22$-9:42
 */

@RestController
public class ShoppingCarController {

    @Resource
    ShoppingCarService shoppingCarService;

    @RequestMapping("/addShoppingCar")
    public List<GoodsInfo> addShoppingCar(Integer sid, Integer num, HttpServletRequest request, HttpServletResponse response){

           Users users = (Users) request.getSession().getAttribute("users");
            if (users==null){
                try {
                    response.getWriter().write("<script>alert('很遗憾，您是未登录的会员，请进行登录');window.location='./front/login.html'</script>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

           Integer uid = users.getUser_id();

           Map<String,Object> map = shoppingCarService.addShoppingCar(uid,sid,num);

           if(map.containsValue("库存充足")){

               List<GoodsInfo> list= new ArrayList<GoodsInfo>();

               list.containsAll(this.queryShoppingCar(users.getUser_id()));

               return list;
           }else {
               try {
                   response.getWriter().write("<script>alert('很遗憾，您所购买的商品数量不足');window.history.back()'</script>");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

        return null;

    }

    @RequestMapping("/ShoppingCar")
    public List<ShoppingCar> ShoppingCar(Integer sid, HttpServletRequest request){

        Users users = (Users) request.getSession().getAttribute("users");

        Integer uid = users.getUser_id();


        return null;

    }

    @RequestMapping("/queryShoppingCar")
    public List<GoodsInfo> queryShoppingCar(Integer uid){

        return shoppingCarService.queryShoppingCar(uid);

    }




}
