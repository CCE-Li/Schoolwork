package cn.uptra.schoolwork.modules.admin.service.impl;

import cn.uptra.schoolwork.modules.admin.entity.Admin;
import cn.uptra.schoolwork.modules.admin.mapper.AdminMapper;
import cn.uptra.schoolwork.modules.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    /**
     * 通过用户名获取管理员信息
     * @param username
     * @return
     */
    @Override
    public Admin getByUsername(String username) {
        return baseMapper.getByUsername(username);
    }
}
