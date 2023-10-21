package com.blogs.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.blogs.dto.StoryDTO;
import com.blogs.entity.Story;
import com.blogs.exception.BloggingException;
import com.blogs.repository.StoryRepository;

@Service(value="StoryService")
@Transactional
public class StoryServiceImpl implements StoryService{
	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public List<StoryDTO> findFirst5ByDateOfCreationLessThanEqualOrderByDateOfCreationDesc(LocalDate currentDate)
			throws BloggingException {
		List<Story> stories = storyRepository.findFirst5ByDateOfCreationLessThanEqualOrderByDateOfCreationDesc(currentDate);
		List<StoryDTO> storydtos = new ArrayList<>();
		if(stories.isEmpty())
			throw new BloggingException("Stories not found in the database");
		stories.forEach(story -> {
			StoryDTO tdto = new StoryDTO();
			tdto.setUserName(story.getUserName());
			tdto.setStoryHeading(story.getStoryHeading());
			tdto.setStoryImagePath(story.getStoryImagePath());
			tdto.setStoryContent(story.getStoryContent());
			tdto.setDateOfCreation(story.getDateOfCreation());
			storydtos.add(tdto);
		});
		return storydtos;
	}
	
	@Override
	public String addStory(StoryDTO storyDTO) throws BloggingException {
		Optional<Story> optional = storyRepository.findById(storyDTO.getStoryHeading());
		
		if(optional.isPresent())
			throw new BloggingException("Story with same heading found please try with different heading.");
		
		Story story = new Story();
		story.setUserName(storyDTO.getUserName());
		story.setStoryHeading(storyDTO.getStoryHeading());
		
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("D:\\I-data\\monster.jpg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	    ByteArrayOutputStream outStreamObj = new ByteArrayOutputStream();
//	    try {
//			ImageIO.write(image, "jpg", outStreamObj);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    byte [] byteArray = outStreamObj.toByteArray();
		
		story.setStoryImagePath(story.getStoryImagePath());
		
		story.setStoryContent(storyDTO.getStoryContent());
		story.setDateOfCreation(storyDTO.getDateOfCreation());
		
		storyRepository.save(story);
		return storyDTO.getStoryHeading();
	}

	@Override
	public StoryDTO getStory(String storyHeading) throws BloggingException {
		Optional<Story> optional = storyRepository.findById(storyHeading);
		Story story = optional.orElseThrow(() -> new BloggingException("Story with this heading not present in database."));
		
		StoryDTO storydto = new StoryDTO();
		storydto.setUserName(story.getUserName());
		storydto.setStoryHeading(story.getStoryHeading());
		storydto.setStoryImagePath(story.getStoryImagePath());
		storydto.setStoryContent(story.getStoryContent());
		storydto.setDateOfCreation(story.getDateOfCreation());
		
//		StoryDTOexit storydtoexit = new StoryDTOexit();
//		storydtoexit.setUserName(story.getUserName());
//		storydtoexit.setStoryHeading(story.getStoryHeading());
//		
//		ByteArrayInputStream inStreambj = new ByteArrayInputStream(story.getStoryImage());
//		try {
//			storydtoexit.setStoryImage(ImageIO.read(inStreambj));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		storydtoexit.setStoryContent(story.getStoryContent());
//		storydtoexit.setDateOfCreation(story.getDateOfCreation());
		
		return storydto;
	}

	@Override
	public void updateStory(String storyHeading, String storyContent) throws BloggingException {
		//this method updates storyContent using id storyHeading
		Optional<Story> optional = storyRepository.findById(storyHeading);
		Story story = optional.orElseThrow(() -> new BloggingException("Story with this heading not present in database."));
		
		story.setStoryContent(storyContent);
	}

	@Override
	public void deleteStory(String storyHeading) throws BloggingException {
		//this method deletes a story with table id storyHeading
		Optional<Story> optional = storyRepository.findById(storyHeading);
		Story story = optional.orElseThrow(() -> new BloggingException("Story with this heading not present in database."));
		storyRepository.deleteById(storyHeading);
	}
}
