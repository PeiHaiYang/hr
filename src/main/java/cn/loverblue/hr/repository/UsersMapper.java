package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


/**
 * @author PHY
 * @date 2020-09-30$-20:22
 */
@Mapper
public interface UsersMapper {

    int addUsers(Users users);

    Users userLogin(Users users);

    // 验证用户的用户名是否唯一
    // public Users checkUsername(String username);
    // 验证用户的用户手机号是否唯一
    // public Users checkTel(String tel);
    // 验证用户的用户邮箱是否唯一
    //public Users checkEmail(String email);

    //验证用户的用户名 手机号 邮箱 是否唯一
    Users check(Map<String,String> map);

}
