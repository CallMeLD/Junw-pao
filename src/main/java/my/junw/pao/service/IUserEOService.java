package my.junw.pao.service;

import jakarta.servlet.http.HttpServletRequest;
import my.junw.pao.entity.UserEO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author ld
 * @since 2024-06-21
 */
public interface IUserEOService extends IService<UserEO> {



    /**
     * 用户注册
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     * 登录-返回用户信息
     * @param userAccount
     * @param userPassword
     * @return
     */
    UserEO doLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList
     * @return
     */
    List<UserEO> searchUsersByTags(List<String> tagNameList);

}
