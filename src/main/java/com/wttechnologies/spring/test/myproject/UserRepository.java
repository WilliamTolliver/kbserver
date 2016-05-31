package com.wttechnologies.spring.test.myproject;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findById(int id);
    List<User> findByfirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByEmail(String email);
    List<User> findByUsername(String username);
    List<User> findByPassword(String password);
}