package com.abhishek.jpahibernate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abhishek.jpahibernate.entity.Person;
import com.abhishek.jpahibernate.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Person -> {}", personJdbcDao.findAll());
		
		logger.info("Person 10001 -> {}", personJdbcDao.findById(10001));
		
		logger.info("No. of rows deleted -> {}", personJdbcDao.deleteById(10002));
		
		Person person = personJdbcDao.findById(10001);
		person.setName("Abhishek");
		
		logger.info("No. of rows updated -> {}", personJdbcDao.update(person));
		
		person.setId(10004);
		person.setName("Naman");
		
		logger.info("No. of rows inserted -> {}", personJdbcDao.insert(person));
	}

}
