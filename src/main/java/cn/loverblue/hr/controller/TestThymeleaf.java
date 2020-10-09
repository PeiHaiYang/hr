package cn.loverblue.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PHY
 * @date 2020-10-03$-18:13
 */
@Controller
public class TestThymeleaf {


    @RequestMapping("/success")
    public String hellp(Model model){
        model.addAttribute("msg","你好世界");
        return "success";
    }
}
