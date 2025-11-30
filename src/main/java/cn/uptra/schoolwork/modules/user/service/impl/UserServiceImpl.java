package cn.uptra.schoolwork.modules.user.service.impl;

import cn.uptra.schoolwork.modules.user.entity.User;
import cn.uptra.schoolwork.modules.user.mapper.UserMapper;
import cn.uptra.schoolwork.modules.user.service.UserService;
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

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        // 生成雪花uid
        Long snowflakeUid = IdWorker.getId();
        // 将生成的uid取模赋值给user的uid
        user.setUid(snowflakeUid);
        return this.save(user);
    }

    public User getUserByUid(Long uid) {
        return this.lambdaQuery().eq(User::getUid, uid).one();
    }

    /**
     * 更新用户密码
     * @param uid
     * @param newPassword
     * @return
     */
    @Override
    public boolean updateUserPassword(Long uid, String newPassword) {
        User user = this.getUserByUid(uid);
        if (user != null) {
            user.setPassword(newPassword);
            return this.updateById(user);
        }
        return false;
    }
}
