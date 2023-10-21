package com.blogs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.StoryDTO;
import com.blogs.exception.BloggingException;
import com.blogs.service.StoryService;

@CrossOrigin
@RestController
@RequestMapping(value="/blogs")
public class UserStoryAPI {
	@Autowired
	private StoryService storyService;
	@Autowired
	private Environment environment;
	
	@GetMapping(value="/getStories")
	public ResponseEntity<List<StoryDTO>> getStories() throws BloggingException{
		List<StoryDTO> listOfdtos = storyService.findFirst5ByDateOfCreationLessThanEqualOrderByDateOfCreationDesc(LocalDate.now());
		return new ResponseEntity<>(listOfdtos, HttpStatus.OK);
	}
	
	@GetMapping(value="/getStory/{storyHeading}")
	public ResponseEntity<StoryDTO> getStory(@PathVariable String storyHeading) throws BloggingException{
		StoryDTO storydtoexit = storyService.getStory(storyHeading);
		return new ResponseEntity<>(storydtoexit, HttpStatus.OK);
	}
	
	@PostMapping(value="/addStory")
	public ResponseEntity<String> addStory(@RequestBody StoryDTO storydto) throws BloggingException{
		String heading = storyService.addStory(storydto);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + heading;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateStory/{storyHeading}")
	public ResponseEntity<String> updateStoryContent(@PathVariable String storyHeading, @RequestBody StoryDTO storydto) throws BloggingException{
		storyService.updateStory(storyHeading, storydto.getStoryContent());
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value="deleteStory/{storyHeading}")
	public ResponseEntity<String> deleteStory(@PathVariable String storyHeading) throws BloggingException{
		storyService.deleteStory(storyHeading);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
