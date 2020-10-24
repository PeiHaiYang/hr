package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.bean.ImgNameAndPath;
import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.service.CommodityService;
import cn.loverblue.hr.service.SearchService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author PHY
 * @date 2020-10-21$-9:45
 */
@Controller
public class SearchController {


    @Resource
    SearchService searchService;


    @RequestMapping("/search")
    public String test(Model model,HttpServletRequest request,String searchVal,
                       @RequestParam(required=true,value="pageNum",defaultValue="1") Integer pageNum,
                       @RequestParam(required=true,value="pageSize",defaultValue="4") Integer pageSize){
        PageInfo<Commodity> commodities = searchService.search(pageNum,pageSize,searchVal);

        model.addAttribute("commodities",commodities);

        return "product-grid";
    }


}
