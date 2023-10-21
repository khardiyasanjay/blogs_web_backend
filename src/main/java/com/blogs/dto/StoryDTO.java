package com.blogs.dto;

import java.io.FileInputStream;
import java.sql.Blob;
import java.time.LocalDate;

public class StoryDTO {
	private String userName;
	private String storyHeading;
	private String storyImagePath;
	private String storyContent;
	private LocalDate dateOfCreation;
	
	public StoryDTO() {
		super();
	}
	
	public StoryDTO(String userName, String storyHeading, String storyImagePath, String storyContent,
			LocalDate dateOfCreation) {
		super();
		this.userName = userName;
		this.storyHeading = storyHeading;
		this.storyImagePath=storyImagePath;
		this.storyContent = storyContent;
		this.dateOfCreation = dateOfCreation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStoryHeading() {
		return storyHeading;
	}
	public void setStoryHeading(String storyHeading) {
		this.storyHeading = storyHeading;
	}
	public String getStoryImagePath() {
		return storyImagePath;
	}

	public void setStoryImagePath(String storyImagePath) {
		this.storyImagePath = storyImagePath;
	}
	public String getStoryContent() {
		return storyContent;
	}
	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}
	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	
	
}
