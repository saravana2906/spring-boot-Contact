package com.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contacts.entity.Contact;



public interface ContactRepository extends CrudRepository<Contact,Long>{
	
	@Query("select c from Contact c join c.user u where u.userid = :userid ORDER BY c.contactId")
	List<Contact>findByUserid(@Param("userid") Long userid);

}
