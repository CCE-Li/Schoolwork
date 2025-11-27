package cn.uptra.schoolwork.Service.Impl;

import cn.uptra.schoolwork.Mapper.UserMapper;
import cn.uptra.schoolwork.Model.User;
import cn.uptra.schoolwork.Service.UserService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return this.lambdaQuery().eq(User::getUsername, username).one();
    }

    @Override
    public boolean saveUser(User user) {
        // 生成雪花uid
        Long snowflakeUid = IdWorker.getId();
        // 将生成的uid取模赋值给user的uid
        user.setUid(snowflakeUid);
        return this.save(user);
    }
}
