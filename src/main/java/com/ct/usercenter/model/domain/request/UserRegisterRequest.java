package com.ct.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author CT
 * @Description //Todo 用户注册请求体
 * @Date 0:14 2022/6/23
 * @Param
 * @return
 **/
@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = -1308506228592201164L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;
}
