package cn.uptra.schoolwork.modules.admin.mapper;

import cn.uptra.schoolwork.modules.admin.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("SELECT * FROM admins WHERE username = #{username}")
    Admin getByUsername(String username);
}
