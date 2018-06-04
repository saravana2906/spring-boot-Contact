package com.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contacts.entity.ContactPhone;

public interface ContactPhoneRepository extends CrudRepository<ContactPhone,Long> {

	@Query("select  cp from ContactPhone cp join cp.contact c where c.user.userid = :userid ORDER BY cp.contact.contactId")
	List<ContactPhone> findByUserid( @Param("userid") Long userid);
}
