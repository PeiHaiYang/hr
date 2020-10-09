package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Dept;
import cn.loverblue.hr.service.DeptService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PHY
 * @date 2020-09-23$-21:31
 */

@RestController
public class SelectEmpController {

    @Resource
    private DeptService deptService;

    @RequestMapping("/t1")
    public List<Dept> findAll(){
        return deptService.findAll();
    };



    @RequestMapping("/t2/{id}")
    public  List<Dept> selectById(@PathVariable int id){
        System.out.println(id);
        return deptService.selectById(id);
    }

    @RequestMapping("/t3")
    public String test(){
        return 1/0+"";
    }
}
