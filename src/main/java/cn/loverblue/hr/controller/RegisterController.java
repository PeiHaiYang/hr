package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PHY
 * @date 2020-09-30$-20:35
 */
@RestController
public class RegisterController {

    static Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    UsersService usersService;

    @RequestMapping("/register")
    public void addUsers(Users users, HttpServletResponse response){

        if(usersService.addUsers(users)==1){
            try {
                logger.info("用户注册成功"+users.getUsername());
                response.sendRedirect("./front/login.html");

            } catch (IOException e) {
                logger.error("用户注册失败"+users.getUsername());
                e.printStackTrace();

            }
        }

    }
    @RequestMapping("/checkUsername")
    public Map checkUsername(@PathVariable String username){
        Users users = usersService.checkUsername(username);
        Map<String, String> map = new HashMap<>();
        if (users.getUsername()==null){
            map.put("msg","ok");
            return map;
        }
        map.put("msg","用户名已经被注册了");
        return null;
    }
    @RequestMapping("/checkTel")
    public Map checkTel(@PathVariable String tel){
        Users users = usersService.checkUsername(tel);
        Map<String, String> map = new HashMap<>();
        if (users.getTel()==null){
            map.put("msg","ok");
            return map;
        }
        map.put("msg","手机号已经被注册了");
        return map;
    }
    @RequestMapping("/checkEmail")
    public Map checkEmail(@PathVariable String email){
        Users users = usersService.checkUsername(email);
        Map<String, String> map = new HashMap<>();
        if (users.getEmail()==null){
            map.put("msg","ok");
            return map;
        }
        map.put("msg","邮箱已经被注册了");
        return map;
    }


}
