package com.blogs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.blogs.dto.StoryDTO;
import com.blogs.service.StoryService;

@SpringBootApplication
public class BloggingWebProjectApplication{ // implements CommandLineRunner{
	
//	public static final Log LOGGER = LogFactory.getLog(BloggingWebProjectApplication.class);
//	
//	@Autowired
//	StoryService storyservice;
//	@Autowired
//	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(BloggingWebProjectApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception{
//		LOGGER.info("welcome to my backend");
//		LOGGER.info("");
//		//addStory();
//		//getStory();
//		//updateStory();
//		deleteStory();
//		LOGGER.info("");
//		LOGGER.info("application run ended");
//	}
//	
//	private void deleteStory() {
//		try {
//			storyservice.deleteStory("this is heading for blog by Monster khardiya");
//			LOGGER.info(environment.getProperty("UserInterface.DELETE_SUCCESS"));
//		} catch (Exception e) {
//			if(e.getMessage()!=null)
//				LOGGER.info(environment.getProperty(e.getMessage(), "deleteStory method not worked. Please check log file for more details"));
//		}
//		
//	}
//
//	private void updateStory() {
//		try {
//			storyservice.updateStory("this is my story heading", "this is updated content for this story");
//			LOGGER.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
//		} catch (Exception e) {
//			if(e.getMessage()!=null)
//				LOGGER.info(environment.getProperty(e.getMessage(), "updateStory method not worked. Please check log file for more details"));
//		}
//	}
//
//	public void getStory() {
//		try {
//			StoryDTO storydto = storyservice.getStory("this is heading for blog by Monster khardiya");
//			LOGGER.info(storydto.getStoryHeading());
//		} catch (Exception e){
//			if(e.getMessage()!=null)	
//				LOGGER.info(environment.getProperty(e.getMessage(), "getStory method not worked. Please check log file for more details"));
//		}
//	}
//	
//	public void addStory() {
//		File file = new File("D:\\I-data\\monster.jpg");
//		byte[] fileContent = new byte[(int) file.length()];
//		FileInputStream inputStream = null;
//		   try {
//			// create an input stream pointing to the file
//			inputStream = new FileInputStream(file);
//			// read the contents of file into byte array
//			inputStream.read(fileContent);
//		   } catch (IOException e) {
//			   LOGGER.info(environment.getProperty(e.getMessage(),"Unable to convert file to byte array. "));
//		   } finally {
//			// close input stream
//			if (inputStream != null) {
//		           try {
//					inputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		   }
//		//use fileContent to send to the db for blob type
//		
//		StoryDTO storydto = new StoryDTO();
//		storydto.setUserName("Monster Khardiya");
//		storydto.setStoryHeading("this is heading for blog by Monster khardiya");
//		storydto.setStoryImage(fileContent);
//		storydto.setStoryContent("Tobacco was first discovered in America. Its cultivation on a wide scale with the help of negro-slaves made it one of the major export items in the American economy. Other parts of the world like Burma and Cuba also cultivated tobacco. Cigarettes made of tobacco rolled in tissue paper helped spread a very harmful habit among the so-called advanced countries of the West. From there it spread to different other countries of the world. Attractive packaging and expert publicity helped spread the addiction to smoking cigarettes even among the poorer sections of the people. But recently it has been detected that the habit of smoking causes different kinds of serious physical ailments, beginning with coughing, sore throat, laryngitis, and asthma, and ending with such a fatal disease as cancer. Besides, for no fault of their own even persons who are liable to inhale cigarette smoke when in the company of a smoker may suffer from any of these diseases. This shows how dangerous the habit of smoking cigarettes is. Besides, smoking cigarettes means a waste of money, since the habit instead of doing any good only causes injury to one’s health and makes one a slave to the addiction. It has been found that by abstaining from smoking a person may be cured of many diseases. He is also relieved of the burden of needless expenses and ultimately becomes a happier and healthier citizen. Therefore, we should all steer clear of this bad habit of smoking cigarettes.");
//		storydto.setDateOfCreation(LocalDate.now());
//		
//		try {
//			String heading = storyservice.addStory(storydto);
//			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS") + heading);
//		} catch(Exception e) {
//			if(e.getMessage()!=null)
//				LOGGER.info(environment.getProperty(e.getMessage(), "something went wrong please check log file for more details."));
//		}
//	}
}
