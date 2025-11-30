package cn.uptra.schoolwork.modules.user.mapper;


import cn.uptra.schoolwork.modules.user.entity.User;
import cn.uptra.schoolwork.modules.user.entity.UserProfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
