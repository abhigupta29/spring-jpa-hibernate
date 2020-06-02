package com.abhishek.jpahibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abhishek.jpahibernate.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Person> findAll() {
		TypedQuery<Person> query = em.createNamedQuery("find_all_persons", Person.class);
		return query.getResultList();
	}
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public void deleteById(int id) {
		Person person = findById(10002);
		em.remove(person);
	}
	
	public Person insert(Person person) {
		return em.merge(person);
	}
	
	public Person update(Person person) {
		return em.merge(person);
	}
}
