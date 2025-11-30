package cn.uptra.schoolwork.modules.book.service.impl;

import cn.uptra.schoolwork.modules.book.entity.Book;
import cn.uptra.schoolwork.modules.book.mapper.BookMapper;
import cn.uptra.schoolwork.modules.book.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    /**
     * 通过bid获取书籍
     * @param bid
     * @return
     */
    @Override
    public List<Book> getBookByBid(Integer bid) {
        return this.baseMapper.getBookByBid(bid);
    }

    /**
     * 通过关键词模糊查询书籍
     * @param keyword
     * @return
     */
    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        return this.baseMapper.searchBooksByKeyword(keyword);
    }

    /**
     * 多条件查询书籍
     * @param author
     * @param title
     * @param tags
     * @return
     */
    @Override
    public List<Book> listBooks(String author, String title, String tags) {
        return this.baseMapper.listBooks(author, title, tags);
    }
}
