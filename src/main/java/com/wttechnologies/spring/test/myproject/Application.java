package com.wttechnologies.spring.test.myproject;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.wttechnologies.spring.test.myproject.User;
import com.wttechnologies.spring.test.util.*;

import org.hibernate.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();


		session.save(new User("William", "Tolliver", "Wtolliver@Nowhere.com", "Wtolliver", "Password" ));

		session.getTransaction().commit();

		Query q = session.createQuery("From User ");

		List<User> resultList = q.list();
		System.out.println("num of employess:" + resultList.size());
		for (User next : resultList) {
			System.out.println("next User: " + next);
		}
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

}