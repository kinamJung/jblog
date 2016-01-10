package com.hanains.jblog.vo;

public class BlogVo {
	private String id;
	private String title;
	private String status;
	private String tags;
	
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", status=" + status + ", tags=" + tags + "]";
	}
	
}