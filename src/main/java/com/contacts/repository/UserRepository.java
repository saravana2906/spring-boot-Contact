package com.contacts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contacts.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findByEmailid(String emailid);

}
