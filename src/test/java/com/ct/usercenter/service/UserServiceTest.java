package com.ct.usercenter.service;
import java.util.Date;

import com.ct.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author CT
 * @Description 用户测试
 * @Date 18:51 2022/6/17
 **/
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("testCt");
        user.setUserPassword("xxx");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.baidu.com/link?url=RGftZGyVonuoSj1jfTil0G86rivbbci2dn_q8RoRewPFa-jKWlq9-KSiqIvVfz_ACfqaLzM_NzR-N21usFTd-KKUem4-_QzP_w5naLr3Era8Rj9e59qwhTXTE2738I9KCiNri07j6X896kRCKugHGu43fj2as-jjmjsjEpCRvLj0q4sXbqnX4PVqSzcu6egnqua3G_n6CxkE1COUMRSWLNE4J9C9uv4IWhVJoHfj8bGwnhBERlfjU5pJxoZ0fjuBlQlnAh2FX2o_XTgvnkclmcQn0F5u70it75mDlh5km927ZXuV2euL-EHHuD2a2Jk77LhP0tI2LL7al91T5mJrnLCVylOkB9_02ZZn-bfV0JYWo82LVZUkqnfT-CIkTJoisSOSlCf6Tj_mkJAcloDiOoj_f4biPmnBQcqukbKlM-g3-EOuos2hdCO82nszFN0dxEMWrNMezNSXYGmjpoVsyc9xzsCFxzSKFK7SCKFl0zkA6e9tibMUPhR61YBYM9zRogFB9-B_EnF3BRaKN40l_-uiWw9zG0ru26ESXxgqFcfWp9V6yxa87RNW3d7ukgOThLHjk2BeFlZS-D_4N4KFxRgzMfCTQDXlwu_OX9FDWUydlpaYO8Dyp125m-ZC8SprOyj-w-e6WOOgP1mm-6_E3sxm1is9l6BGE9tGeP6eaUSvr1rNMlKDi30-bXGqe5Zj&wd=&eqid=febcb6c2000176480000000662ac5e5a");
        user.setGender(0);
        user.setEmail("456");
        user.setPhone("123");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "dogyupi";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yupi";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertTrue(result > 0);
    }
}