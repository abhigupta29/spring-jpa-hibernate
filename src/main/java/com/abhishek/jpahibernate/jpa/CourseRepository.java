package com.abhishek.jpahibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abhishek.jpahibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void delete(Long id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}
	
	public void save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
	}
	
	public List<Course> findAll() {
		return em.createQuery("select c from Course c", Course.class).getResultList();
	}
}
