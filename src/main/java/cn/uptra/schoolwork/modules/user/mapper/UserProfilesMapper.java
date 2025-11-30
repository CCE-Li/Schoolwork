package cn.uptra.schoolwork.modules.user.mapper;

import cn.uptra.schoolwork.modules.user.entity.UserProfiles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserProfilesMapper extends BaseMapper<UserProfiles> {
    @Select("""
            SELECT * FROM user_profiles WHERE uid = #{uid}
            """)
    UserProfiles getUserProfilesByUid(Long uid);
}
