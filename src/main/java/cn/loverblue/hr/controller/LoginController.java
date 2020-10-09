package cn.loverblue.hr.controller;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.service.UsersService;
import cn.loverblue.hr.utils.MailSend;
import cn.loverblue.hr.utils.RandomNum;
import cn.loverblue.hr.utils.RegexMatch;
import cn.loverblue.hr.utils.SmsUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PHY
 * @date 2020-09-24$-21:11
 */
@Slf4j
@RestController
public class LoginController {


    @Resource
    UsersService usersService;

    @RequestMapping("/login")
    public Map<String,String> login(Users users, HttpServletRequest request){

        Map<String,String> results = new HashMap<>();

        if (users!=null) {
            request.getSession().setAttribute("users", users);
         }
        String emailflag= "/^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$/";
        Users userLogin = null;
        if (users.getUsername()!=null&&"".equals(users.getPassword())){

            if (RegexMatch.isLegalInputLine(users.getUsername())){

                users.setTel(users.getUsername());

                users.setUsername(null);

                userLogin = usersService.userLogin(users,request);
            }else{
                List<String> str = RegexMatch.getString(users.getUsername(), emailflag);

                System.out.println(str.toString());

                users.setEmail(users.getUsername());

                users.setUsername(null);

                userLogin = usersService.userLogin(users,request);
            }

        }

        if (userLogin!= null) {

            if(users.getTel()!=null){

                String code = SmsUtils.sendSms(users.getTel());

                log.info("成功发送短信"+users.getTel());

                request.getSession().setAttribute("code",code);

                results.put("msg","ok");

                return results;
            }
            if(users.getEmail()!=null){

                MailSend mailSend = new MailSend();

                mailSend.setTo(users.getEmail());

                String code = RandomNum.Rand();

                mailSend.setCode(code);

                request.getSession().setAttribute("code",code);

                new Thread(mailSend).start();

                results.put("msg","ok");

                return results;
            }

        }
        return results;
     }

     @RequestMapping("userLogin")
      public Map<String, String> userLogin(Users users, HttpServletRequest request){

          Map<String,String> results = new HashMap<>();

          if(users.getUsername()!=null&&users.getPassword()!=null&&!"".equals(users.getPassword())){

              String code = (String) request.getSession().getAttribute("code");

              if(users.getPassword().equals(code)){

                  results.put("msg","ok");

                  return results;

              }else{

                  Users userLogin = usersService.userLogin(users,request);

                  if(userLogin!=null){

                      results.put("msg","ok");

                      return results;
                  }

              }
          }
          return results;
      }

}
