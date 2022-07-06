package com.ct.usercenter.service;

import com.ct.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author CTtao
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-06-17 18:46:13
*/
public interface UserService extends IService<User> {

    /**
     * @Author CT
     * @Description //Todo 用户注册
     * @Date 19:22 2022/6/17
     * @Param [userAccount, userPassword, checkPassword, planetCode]
     * @return long
     **/
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    /**
     * @Author CT
     * @Description //Todo 用户登录
     * @Date 21:22 2022/6/21
     * @Param [userAccount, userPassword]
     * @return com.ct.usercenter.model.domain.User 脱敏后的用户信息
     **/
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * @Author CT
     * @Description //Todo 用户脱敏
     * @Date 20:39 2022/6/23
     * @Param [originUser]
     * @return com.ct.usercenter.model.domain.User
     **/
    User getSafetyUser(User originUser);


    /**
     * @Author CT
     * @Description //Todo 用户注销
     * @Date 19:17 2022/7/3
     * @Param [request]
     * @return int
     **/
    int userLogout(HttpServletRequest request);
}
