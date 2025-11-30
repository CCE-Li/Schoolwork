package cn.uptra.schoolwork.modules.user.service.impl;

import cn.uptra.schoolwork.modules.book.entity.Book;
import cn.uptra.schoolwork.modules.user.entity.UserFavourites;
import cn.uptra.schoolwork.modules.user.mapper.UserFavouriteMapper;
import cn.uptra.schoolwork.modules.user.service.UserFavouriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavouriteServiceImpl extends ServiceImpl<UserFavouriteMapper, UserFavourites> implements UserFavouriteService {
    /**
     * 为用户收藏表设置uid
     * @param uid
     */
    @Override
    public void setUserFavouriteUid(Long uid) {
        UserFavourites userFavourites = new UserFavourites();
        userFavourites.setUid(uid);
        this.save(userFavourites);
    }

    @Resource
    private UserFavouriteMapper userFavouriteMapper;

    /**
     * 通过uid获取用户收藏表
     * @param uid
     * @return
     */
    @Override
    public List<UserFavourites> getUserFavouriteByUid(Long uid) {
        List<UserFavourites> favourites = userFavouriteMapper.getUserFavouriteByUid(uid);
        return favourites;
    }

    /**
     * 使用userfavourites中的bid去book表中查询收藏记录
     * @param uid
     * @return
     */
    @Override
    public List<Book> getFavouriteBooksByUid(Long uid) {
        List<Book> favouriteBooks = userFavouriteMapper.getFavouriteBooksByUid(uid);
        return favouriteBooks;
    }
}
