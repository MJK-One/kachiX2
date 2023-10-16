package com.kachi.five.bean;

import java.math.BigDecimal;
import java.sql.Date;

import com.google.protobuf.Timestamp;

public class PostBean {
	
		private int postId;
	    private String writerId;
	    private int categoryId;
	    private String title;
	    private String content;
	    private BigDecimal price;  
	    private BigDecimal totalprice; 
	    private Timestamp postDate;  
	    private Date salePeriod; 
	    private boolean saleStatus;
	    private int discountRate;
	    private String MainImageUrl;
	    private String ContentImageUrl;
		public int getPostId() {
			return postId;
		}
		public void setPostId(int postId) {
			this.postId = postId;
		}
		public String getWriterId() {
			return writerId;
		}
		public void setWriterId(String writerId) {
			this.writerId = writerId;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Timestamp getPostDate() {
			return postDate;
		}
		public void setPostDate(Timestamp postDate) {
			this.postDate = postDate;
		}
		public Date getSalePeriod() {
			return salePeriod;
		}
		public void setSalePeriod(Date salePeriod) {
			this.salePeriod = salePeriod;
		}
		public boolean isSaleStatus() {
			return saleStatus;
		}
		public void setSaleStatus(boolean saleStatus) {
			this.saleStatus = saleStatus;
		}
		public int getDiscountRate() {
			return discountRate;
		}
		public void setDiscountRate(int discountRate) {
			this.discountRate = discountRate;
		}
		public String getMainImageUrl() {
			return MainImageUrl;
		}
		public void setMainImageUrl(String mainImageUrl) {
			MainImageUrl = mainImageUrl;
		}
		public String getContentImageUrl() {
			return ContentImageUrl;
		}
		public void setContentImageUrl(String contentImageUrl) {
			ContentImageUrl = contentImageUrl;
		}
		public BigDecimal getTotalprice() {
			return totalprice;
		}
		public void setTotalprice(BigDecimal totalprice) {
			this.totalprice = totalprice;
		}	
	    
	    
}
