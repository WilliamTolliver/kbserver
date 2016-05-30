package com.wttechnologies.spring.test.myproject;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wttechnologies.spring.test.util.HibernateUtil;

@RestController
public class UserController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getUsers(){
		return "Hello Controoollaaaah";
	}
}