package com.kachi.five.DAO;

import java.util.List;

public interface WishlistDAO {
	 	void addToWishlist(String userId, int postId);
	    void removeFromWishlist(String userId, int postId);
	    List<Integer> getWishlistByUser(String userId);
	    boolean isPostInWishlist(String userId, int postId);
}
