package com.kachi.five.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kachi.five.DAO.WishlistDAO;
@Service
public class WishlistServiceImpl implements WishlistService {
    @Autowired
    private WishlistDAO wishlistDAO;

    @Override
    public void addToWishlist(String userId, int postId) {
        wishlistDAO.addToWishlist(userId, postId);
    }

    @Override
    public void removeFromWishlist(String userId, int postId) {
        wishlistDAO.removeFromWishlist(userId, postId);
    }

    @Override
    public List<Integer> getWishlistByUser(String userId) {
        return wishlistDAO.getWishlistByUser(userId);
    }

	@Override
	public boolean isPostInWislist(String UserId, int PostId) {
		
		return wishlistDAO.isPostInWishlist(UserId, PostId);
	}
    

}
