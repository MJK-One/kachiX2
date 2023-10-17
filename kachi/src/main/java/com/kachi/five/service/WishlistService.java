package com.kachi.five.service;

import java.util.List;

public interface WishlistService {
	   void addToWishlist(String userId, int postId);
	   void removeFromWishlist(String userId, int postId);
	   List<Integer> getWishlistByUser(String userId);
	   boolean isPostInWislist (String UserId,int PostId);
}
