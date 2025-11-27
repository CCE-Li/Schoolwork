package cn.uptra.schoolwork.Controller;


import cn.uptra.schoolwork.Model.R;
import cn.uptra.schoolwork.Model.User;
import cn.uptra.schoolwork.Service.Impl.UserServiceImpl;
import cn.uptra.schoolwork.Service.UserService;
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


    /**
     * 注册接口： （post请求，明文注册uid和密码）
     * @param user 前端传递的uid + 密码
     * @return  统一响应：成功返回用户信息，失败返回错误提示
     */
    @PostMapping("/regist")
    public R<User> regist(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User dbUser = userService.getUserByUsername(username);
        if (dbUser != null) {
            return R.error("用户已存在");
        }
        else {
            userService.saveUser(user);
            return R.success(user);
        }
    }

}
