package com.contacts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.contacts.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findByEmailid(String emailid);

}
