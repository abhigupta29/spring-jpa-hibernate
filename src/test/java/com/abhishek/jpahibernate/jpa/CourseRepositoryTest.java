package com.abhishek.jpahibernate.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.abhishek.jpahibernate.JpaApplication;
import com.abhishek.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void findById_test() {
		Course course = courseRepository.findById(20001L);
		assertEquals("SPRING IN 50 STEPS", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void delete_test() {
		courseRepository.delete(20001L);
		assertNull(courseRepository.findById(20001L));
	}
	
	@Test
	@DirtiesContext
	public void save_test() {
		Course course = courseRepository.findById(20001L);
		assertEquals("SPRING IN 50 STEPS", course.getName());
		
		course.setName("SPRING IN 100 STEPS");
		courseRepository.save(course);
		
		Course course1 = courseRepository.findById(20001L);
		assertEquals("SPRING IN 100 STEPS", course1.getName());
	}
	
	@Test
	public void findAll_test() {
		List<Course> courses = courseRepository.findAll();
		logger.info("Courses -> {}", courses);
	}
	
	@Test
	@Transactional
	public void play_with_entity_manager() {
		Course course = new Course("Microservices");
		em.persist(course);
		course.setName("Microservices in 100 steps");
		logger.info("Course -> {}",em.find(Course.class, 1L).getName());
	}
}
