package cn.uptra.schoolwork.modules.user.controller;


import cn.uptra.schoolwork.modules.user.service.UserProfileService;
import cn.uptra.schoolwork.modules.user.service.UserService;
import cn.uptra.schoolwork.common.result.R;
import cn.uptra.schoolwork.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // 前端接口
public class RegistController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;


    /**
     * 注册接口： （post请求，明文注册uid和密码）
     * @param user 前端传递的uid + 密码
     * @return  统一响应：成功返回用户信息，失败返回错误提示
     */
    @PostMapping("/regist")
    public R<User> regist(@RequestBody User user) {
        String username = user.getUsername();
        User dbUser = userService.getUserByUsername(username);
        if (dbUser != null) {
            return R.error("用户已存在");
        }
        else {
            userService.saveUser(user);
            // 同时创建一个用户信息表的记录
            userProfileService.setUserProfilesUid(user.getUid());
            return R.success(user);
        }
    }

}
