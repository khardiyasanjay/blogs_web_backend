package com.blogs.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blogs.dto.StoryDTO;
import com.blogs.entity.Story;


public interface StoryRepository extends CrudRepository<Story, String>{
	List<Story> findFirst5ByDateOfCreationLessThanEqualOrderByDateOfCreationDesc(LocalDate currentDate);
}
