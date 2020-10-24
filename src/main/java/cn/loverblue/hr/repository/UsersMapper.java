package cn.loverblue.hr.repository;

import cn.loverblue.hr.bean.Users;
import cn.loverblue.hr.bean.UsersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    @Delete({
        "delete from users",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer user_id);

    @Insert({
        "insert into users (user_id, user_name, ",
        "password, tel, email, ",
        "sex, joinTime, ",
        "picPath, state)",
        "values (#{user_id,jdbcType=INTEGER}, #{user_name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{joinTime,jdbcType=TIMESTAMP}, ",
        "#{picPath,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR})"
    })
    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    @Select({
        "select",
        "user_id, user_name, password, tel, email, sex, joinTime, picPath, state",
        "from users",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    @ResultMap("cn.loverblue.hr.repository.UsersMapper.BaseResultMap")
    Users selectByPrimaryKey(Integer user_id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    @Update({
        "update users",
        "set user_name = #{user_name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "joinTime = #{joinTime,jdbcType=TIMESTAMP},",
          "picPath = #{picPath,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR}",
        "where user_id = #{user_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);

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