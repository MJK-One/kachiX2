package com.kachi.five.bean;

import com.google.protobuf.Timestamp;

public class GroupBuyBean {
	private int groupBuyID;
    private String creatorID;
    private String creatorName;
    private String participantID;
    private int postID;
    private String status;
    private Timestamp startTime;
	public int getGroupBuyID() {
		return groupBuyID;
	}
	public void setGroupBuyID(int groupBuyID) {
		this.groupBuyID = groupBuyID;
	}
	public String getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(String creatorID) {
		this.creatorID = creatorID;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getParticipantID() {
		return participantID;
	}
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
    
    
}
