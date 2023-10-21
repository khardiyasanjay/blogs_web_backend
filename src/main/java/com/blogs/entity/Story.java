package com.blogs.entity;

import java.io.FileInputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="story")
public class Story {
	//in naming camelCase will change to underscore in db and table name in lowercase
	@Column(name="user_name")
	private String userName;
	@Id @Column(name="story_heading")
	private String storyHeading;
	@Column(name="story_image_path")
	private String storyImagePath;
	@Column(name="story_content")
	private String storyContent;
	@Column(name="date_of_creation")
	private LocalDate dateOfCreation;
	
	public Story() {
		super();
	}
	
	public Story(String userName, String storyHeading, String storyImagePath, String storyContent, LocalDate dateOfCreation) {
		super();
		this.userName = userName;
		this.storyHeading = storyHeading;
		this.storyImagePath = storyImagePath;
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

	@Override
	public int hashCode() {
		return Objects.hash(storyHeading);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		return Objects.equals(storyHeading, other.storyHeading);
	}
	
	
}
