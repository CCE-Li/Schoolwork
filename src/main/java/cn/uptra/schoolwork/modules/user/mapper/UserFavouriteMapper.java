package cn.uptra.schoolwork.modules.user.mapper;

import cn.uptra.schoolwork.modules.book.entity.Book;
import cn.uptra.schoolwork.modules.user.entity.UserFavourites;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface UserFavouriteMapper extends BaseMapper<UserFavourites> {

    @Select("SELECT * FROM user_favourites WHERE uid = #{uid} ")
    List<UserFavourites> getUserFavouriteByUid(Long uid);

    // 使用userfavourites中的bid去book表中查询收藏记录
    @Select("SELECT b.* FROM books b INNER JOIN user_favourites uf ON b.bid = uf.bid WHERE uf.uid = #{uid} ")
    List<Book> getFavouriteBooksByUid(Long uid);
}
