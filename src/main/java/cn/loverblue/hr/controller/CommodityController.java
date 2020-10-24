package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.bean.ImgNameAndPath;
import cn.loverblue.hr.service.CommodityService;
import cn.loverblue.hr.utils.PageHelperUtils;
import com.github.pagehelper.PageInfo;
import com.sun.media.sound.ModelDestination;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

/**
 * @author PHY
 * @date 2020-10-15$-11:38
 */
@Controller

public class CommodityController {


    @Resource
    CommodityService commodityService;



    //多条件查询进行查找商品
    @RequestMapping("/oderBy")
    public String query(String orderByBrand,String orderByPrice, Model model,
                        @RequestParam(required=true,value="pageNum",defaultValue="1") Integer pageNum,
                        @RequestParam(required=true,value="pageSize",defaultValue="5") Integer pageSize,
                        HttpServletRequest request
                        ){

        System.out.println(orderByBrand);
        System.out.println(orderByPrice);
        if (request.getSession().getAttribute("category_id")!=null){

            String category_id = (String) request.getSession().getAttribute("category_id");

            PageInfo<Commodity> commodities = commodityService.findOrderByPage(pageNum,pageSize,category_id,orderByBrand,orderByPrice);

            model.addAttribute("category_id",category_id);

            List<ImgNameAndPath> imgnameandpath = commodityService.sort();

            model.addAttribute("imgnameandpath",imgnameandpath);

            model.addAttribute("commodities",commodities);

            return "product-list";
        }else {

            return "/err.html";
        }

    }
    /*
    * 商品list的分页显示
    *
    * */
    @RequestMapping("/selectBySort")
    public String commodities(@RequestParam(required = true,value = "category_id",defaultValue="2") String category_id,
                              Model model,
                              @RequestParam(required=true,value="pageNum",defaultValue="1") Integer pageNum,
                              @RequestParam(required=true,value="pageSize",defaultValue="4") Integer pageSize,
                              HttpServletRequest request){

        PageInfo<Commodity> commodities = commodityService.findByPage(pageNum,pageSize,category_id);

        model.addAttribute("commodities",commodities);
        /*
        将商品的类型存起来
        */
        model.addAttribute("category_id",category_id);

        request.getSession().setAttribute("category_id",category_id);

        List<ImgNameAndPath> imgnameandpath = commodityService.sort();

        model.addAttribute("imgnameandpath",imgnameandpath);

        return "product-list";
    }

    /*主页在导航栏点击更多产品，查询出所有产品*/
     @RequestMapping("/selectall")
    public  String selectall(Model model,
                             @RequestParam(required=true,value="pageNum",defaultValue="1") Integer pageNum,
                             @RequestParam(required=true,value="pageSize",defaultValue="4") Integer pageSize){


         PageInfo<Commodity> commodities = commodityService.selectAll(pageNum, pageSize);

         model.addAttribute("commodities",commodities);
         List<ImgNameAndPath> imgnameandpath = commodityService.sort();

         model.addAttribute("imgnameandpath",imgnameandpath);

         return "product-grid";
     }
     /*查询出所有商品后，分页部分*/
     @RequestMapping("/selectallShowPage/{pageNum}")
     public  String selectallShowPage(Model model,
                              @PathVariable Integer pageNum,
                              @RequestParam(required=true,value="pageSize",defaultValue="4") Integer pageSize){
         System.out.println(pageNum);
         PageInfo<Commodity> commodities = commodityService.selectAll(pageNum, pageSize);

         model.addAttribute("commodities",commodities);

         List<ImgNameAndPath> imgnameandpath = commodityService.sort();

         model.addAttribute("imgnameandpath",imgnameandpath);

         return "product-grid";
     }


    @RequestMapping("/commodityListShowPage/{category_id}/{pageNum}")
    public String commodityListShowPage(@PathVariable String category_id, Model model,
                                        @PathVariable Integer pageNum,
                                        @RequestParam(required=true,value="pageSize",defaultValue="4") Integer pageSize){


        PageInfo<Commodity> commodities = commodityService.findByPage(pageNum,pageSize,category_id);

        model.addAttribute("commodities",commodities);

        model.addAttribute("category_id",category_id);

        List<ImgNameAndPath> imgnameandpath = commodityService.sort();

        model.addAttribute("imgnameandpath",imgnameandpath);

        return "product-list";
    }
    /*主页按销量的商品详情*/
    @RequestMapping("/commoditydetail")
    public String commoditydetail(Integer id,Model model){

        Commodity commodity = commodityService.commodityDetail(id);

        System.out.println(commodity);

        model.addAttribute("commodity",commodity);
        List<Commodity> commodity1=commodityService.relateBySort(id);
        model.addAttribute("commodity1",commodity1);
        return "product-details";
    }
    @RequestMapping("/tt")
    public String order(){

        return "order";
    }
    @RequestMapping("/ttt")
    public String order123(){

        return "order";
    }
}
