package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.*;
import cn.loverblue.hr.service.CommodityService;
import cn.loverblue.hr.service.UsersService;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author PHY
 * @date 2020-10-14$-11:30
 */
@Controller
public class indexThymeleaf {

    @Resource
    CommodityService commodityService;

    @Resource
    UsersService usersService;
     /*主页初始化*/
    @RequestMapping("/front")
    public String index(Model model, HttpServletRequest request){

        Users users = null;

        if ((Users) request.getSession().getAttribute("users") == null) {


            model.addAttribute("users",users);

        }else {

            users = (Users) request.getSession().getAttribute("users");
            model.addAttribute("users",users);
        }
        List<Commodity> commodities = commodityService.sellWell();

        model.addAttribute("commodities",commodities);

        List<ImgNameAndPath> imgnameandpath=commodityService.sort();

        model.addAttribute("imgnameandpath",imgnameandpath);

        List<Commodity> commoditiess = commodityService.selectBad();

        model.addAttribute("commoditiess",commoditiess);

        return "index";
    }

}
