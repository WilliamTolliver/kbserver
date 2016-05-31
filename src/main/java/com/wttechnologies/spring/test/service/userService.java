package com.wttechnologies.spring.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.wttechnologies.spring.test.myproject.Application;
import com.wttechnologies.spring.test.myproject.User;
import com.wttechnologies.spring.test.myproject.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Service
@Transactional
public class userService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "/users")
	public Iterable<User> getUsers() {

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (User user : repository.findAll()) {
			log.info(user.toString());
		}

		return repository.findAll();
	}
}