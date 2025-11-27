package cn.uptra.schoolwork.Service;


import cn.uptra.schoolwork.Model.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    public User getUserByUsername(String username);
    public boolean saveUser(User user);

}
