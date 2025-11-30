package cn.uptra.schoolwork.modules.book.service.impl;

import cn.uptra.schoolwork.modules.book.entity.Review;
import cn.uptra.schoolwork.modules.book.mapper.ReviewMapper;
import cn.uptra.schoolwork.modules.book.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    @Override
    public Double getAverageRatingByBid(Integer bid) {
        return this.baseMapper.getAverageRatingByBid(bid);
    }

    @Override
    public Integer getReviewCountByBid(Integer bid) {
        return this.baseMapper.getReviewCountByBid(bid);
    }

    @Override
    public Integer hasUserReviewedBook(Integer bid, Long uid) {
        return this.baseMapper.hasUserReviewedBook(bid, uid);
    }

    @Override
    public Review getUserReviewForBook(Integer bid, Long uid) {
        return this.baseMapper.getUserReviewForBook(bid, uid);
    }

    @Override
    public List<Review> getAllReviewsByBid(Integer bid) {
        return this.baseMapper.getAllReviewsByBid(bid);
    }

    @Override
    public List<Review> getAllReviewsByUid(Long uid) {
        return this.baseMapper.getAllReviewsByUid(uid);
    }
}
