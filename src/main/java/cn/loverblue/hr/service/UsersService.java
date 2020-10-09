package cn.loverblue.hr.service;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.repository.UsersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author PHY
 * @date 2020-09-30$-20:20
 */
@Service
public class UsersService {

    static  Logger logger = LoggerFactory.getLogger(UsersService.class);
    @Resource
    UsersMapper usersMapper;

    /*
    添加用户信息
    */
    public int addUsers(Users users){
       return usersMapper.addUsers(users) ;
    }
    /*
    对用户的用户名进行查询 如果重复 将返回给前端已经注册完毕
    */
    public Users checkUsername(String username){
        Map<String, String> map = new HashMap<String, String>();
        map.put("username",username);
        return usersMapper.check(map);
    }

    /*
     对用户的手机号进行查询 如果重复 将返回给前端已经注册完毕
    */
    public Users checkTel(String tel){
        Map<String, String> map = new HashMap<String, String>();
        map.put("tel",tel);
        return usersMapper.check(map);
    }

    /*
     对用户的邮箱进行查询 如果重复 将返回给前端已经注册完毕
    */
    public Users checkEmail(String email){
        Map<String, String> map = new HashMap<String, String>();
        map.put("email",email);
        return usersMapper.check(map);
    }

   public Users userLogin(Users users,HttpServletRequest request){

       Users Ddusers = usersMapper.userLogin(users);

        if(Ddusers!=null){

           logger.info("登录用户为"+Ddusers.getUserId());

           request.getSession().removeAttribute("users");

           request.getSession().setAttribute("users",Ddusers);

           return Ddusers;
       }
        /*如果没有这个用户，经结果设置为空*/
       return null;
   }




}
