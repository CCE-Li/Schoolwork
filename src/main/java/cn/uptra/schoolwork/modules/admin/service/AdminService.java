package cn.uptra.schoolwork.modules.admin.service;

import cn.uptra.schoolwork.modules.admin.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminService extends IService<Admin> {
    Admin getByUsername(String username);
}
