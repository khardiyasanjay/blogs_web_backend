package com.blogs.service;

import java.time.LocalDate;
import java.util.List;

import com.blogs.dto.StoryDTO;
import com.blogs.entity.Story;
import com.blogs.exception.BloggingException;

public interface StoryService {
	//basic crud operation
	public String addStory(StoryDTO storydto) throws BloggingException;
	public StoryDTO getStory(String storyHeading) throws BloggingException;
	public void updateStory(String storyHeading, String storyContent) throws BloggingException;
	public void deleteStory(String storyHeading) throws BloggingException;
	
	//query creation based on method name
	public List<StoryDTO> findFirst5ByDateOfCreationLessThanEqualOrderByDateOfCreationDesc(LocalDate currentDate) throws BloggingException;
}
