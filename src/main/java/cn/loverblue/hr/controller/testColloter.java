package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Commodity;
import cn.loverblue.hr.service.CommodityService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author PHY
 * @date 2020-10-19$-8:53
 */

@RestController
public class testColloter {

    @Resource
    CommodityService commodityService;

    @RequestMapping("/tt55")
    public PageInfo<Commodity> test01(){

        return commodityService.findByPage(1,5,"2");

    }
}
