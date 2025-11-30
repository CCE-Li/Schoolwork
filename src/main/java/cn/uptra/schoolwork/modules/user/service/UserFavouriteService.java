package cn.uptra.schoolwork.modules.user.service;

import cn.uptra.schoolwork.modules.book.entity.Book;
import cn.uptra.schoolwork.modules.user.entity.UserFavourites;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserFavouriteService extends IService<UserFavourites> {
    // 添加一条uid
    void setUserFavouriteUid(Long uid);
    List<UserFavourites> getUserFavouriteByUid(Long uid);
    List<Book> getFavouriteBooksByUid(Long uid);
}
