package my.junw.pao.service.Impl;

import jakarta.annotation.Resource;
import my.junw.pao.entity.UserEO;
import my.junw.pao.service.IUserEOService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserEOServiceTest {

    @Resource
    private IUserEOService userService;

    /**
     * 测试添加用户
     */
    @Test
    public void testAddUser(){
        UserEO user = new UserEO();
        user.setUsername("测试1");
        user.setUserAccount("admin1");
        user.setAvatarUrl("/头像");
        user.setGender(0);
        user.setUserPassword("123456");
        user.setPhone("123456");
        user.setEmail("123456@qq.com");
        user.setUserStatus(0);
        boolean result =  userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    /**
     * 测试注册用户
     */
    @Test
    void userRegister() {
        // 入参存在空值
        String userAccount = "junw";
        String password = "12345678";
        String checkPassword = "";
        long rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertEquals(-1,rs);
        // 账号长度 < 4
        userAccount = "jw";
        password = "12345678";
        checkPassword = "12345678";
        rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertEquals(-1,rs);
        // 账号包含特殊字符
        userAccount = "ju!nw";
        rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertEquals(-1,rs);
        // 密码与校验密码不一致
        userAccount = "junw";
        password = "12345678";
        checkPassword = "1234!5678";
        rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertEquals(-1,rs);
        // 账号重复
        userAccount = "admin1";
        checkPassword = "12345678";
        rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertEquals(-1,rs);

        // 正常
        userAccount = "junw";
        password = "12345678";
        checkPassword = "12345678";
        rs = userService.userRegister(userAccount,password,checkPassword);
        Assertions.assertTrue(rs > 0);

    }




}