package cn.uptra.schoolwork.modules.user.controller;

import cn.uptra.schoolwork.common.result.R;
import cn.uptra.schoolwork.modules.user.entity.User;
import cn.uptra.schoolwork.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth") // 前端接口
public class LoginController {
    @Autowired
    private UserService userService;


    /**
     * 登录接口 （post请求，明文验证uid和密码）
     * @param user 前端传递的uid + 密码
     * @return 统一响应：成功返回用户信息，失败返回错误提示
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 直接查询管理员用户
        if (username.equals("admin") && password.equals("admin123")) {
            return R.success();
        }
        // 从数据库查询登录用户
        User dbUser = userService.getUserByUsername(username);
        if (dbUser == null) {
            return R.error("用户不存在");
        }
        else if (!dbUser.getPassword().equals(password)) {
            return R.error("密码错误");
        } else {
            return R.success(dbUser);
        }
    }
}
