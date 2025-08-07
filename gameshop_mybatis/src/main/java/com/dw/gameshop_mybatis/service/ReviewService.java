package com.dw.gameshop_mybatis.service;

import com.dw.gameshop_mybatis.dto.ReviewDTO;
import com.dw.gameshop_mybatis.enums.GameRating;
import com.dw.gameshop_mybatis.exception.PermissionDeniedException;
import com.dw.gameshop_mybatis.exception.ResourceNotFoundException;
import com.dw.gameshop_mybatis.mapper.GameMapper;
import com.dw.gameshop_mybatis.mapper.PurchaseMapper;
import com.dw.gameshop_mybatis.mapper.ReviewMapper;
import com.dw.gameshop_mybatis.mapper.UserMapper;
import com.dw.gameshop_mybatis.model.Game;
import com.dw.gameshop_mybatis.model.Review;
import com.dw.gameshop_mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    GameMapper gameMapper;
    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    ReviewMapper reviewMapper;

    @Transactional
    public int saveReview(ReviewDTO reviewDto) {
        User user = userMapper.getUserByUserName(reviewDto.getUserName());
        if (user == null) {
            throw new ResourceNotFoundException("User not found with name: " + reviewDto.getUserName());
        }
        Game game = gameMapper.getGameById(reviewDto.getGame().getId());
        if (game == null) {
            throw new ResourceNotFoundException("Game not found with ID: " + reviewDto.getGame().getId());
        }

        // 구매 이력 확인 로직
        int purchaseCount = purchaseMapper.countPurchaseByUserNameAndGameId(
                reviewDto.getUserName(),
                reviewDto.getGame().getId()
        );

        if (purchaseCount == 0) {
            throw new PermissionDeniedException("리뷰를 작성하려면 먼저 게임을 구매해야 합니다.");
        }

        Review review = new Review();
        review.setUser(user);
        review.setGame(game);
        review.setPoint(GameRating.valueOf(reviewDto.getPoint().name()));
        review.setReviewText(reviewDto.getReviewText());

        return reviewMapper.saveReview(review);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> getReviewsByGameId(Long gameId) {
        List<Review> reviews = reviewMapper.findByGameId(gameId);
        return reviews.stream()
                .map(Review::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public String deleteReview(Long reviewId, User currentUser) {
        Review review = reviewMapper.findById(reviewId);
        if (review == null) {
            throw new ResourceNotFoundException("Review not found with ID: " + reviewId);
        }
        if (!currentUser.getUserName().equals(review.getUser().getUserName())) {
            throw new PermissionDeniedException("리뷰 작성자가 아니므로 삭제 권한이 없습니다.");
        }
        int deletedRows = reviewMapper.deleteReview(reviewId);
        if (deletedRows > 0) {
            return "리뷰 ID=" + reviewId + "가 정상적으로 삭제되었습니다.";
        }else {
            return "리뷰를 삭제하는 데 실패했습니다.";
        }
    }
}
