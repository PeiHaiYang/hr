package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @RequestMapping("/register1")
    public void addUsers(Users users, HttpServletResponse response){

        if(usersService.addUsers(users)==1){
            try {
                logger.info("用户注册成功"+users.getUser_name());
                System.out.println(123);
                response.sendRedirect("front/login.html");

            } catch (IOException e) {
                logger.error("用户注册失败"+users.getUser_name());
                e.printStackTrace();

            }
        }else {
            logger.error("用户注册失败"+users.getUser_name());
            System.out.println("注册失败");
        }

    }

    @RequestMapping("/checkUsername")
    public  Map<String, String> checkUsername(String user_name){
        logger.info(user_name);
        Users users = usersService.checkUsername(user_name);
        Map<String, String> map = new HashMap<>();
        if (users!=null){
            map.put("msg","用户名已经被注册了");
        }else {
            map.put("msg","ok");
            return map;
        }
        return map;
    }
    @RequestMapping("/checkTel")
    public  Map<String, String> checkTel(String tel){
        Users users = usersService.checkTel(tel);
        Map<String, String> map = new HashMap<>();
        if (users!=null){
            map.put("msg","手机号已经被注册了");
        }else {
            map.put("msg","ok");
            return map;
        }
        return map;
    }
    @RequestMapping("/checkEmail")
    public  Map<String, String> checkEmail(String email){
        Users users = usersService.checkEmail(email);
        Map<String, String> map = new HashMap<>();
        if (users!=null){
            map.put("msg","邮箱已经被注册了");
        }else {
            map.put("msg","ok");
            return map;
        }
        return map;
    }




}
