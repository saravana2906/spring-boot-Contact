package com.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contacts.entity.ContactPhone;

@Repository
public interface ContactPhoneRepository extends CrudRepository<ContactPhone,Long> {

	@Query("select  cp from ContactPhone cp join cp.contact c where c.user.userid = :userid ORDER BY cp.contact.contactId")
	List<ContactPhone> findByUserid( @Param("userid") Long userid);
	
	@Query("select  cp from ContactPhone cp join cp.contact c where c.user.userid = :userid and c.contactId = :contactId ORDER BY cp.phoneID")
	List<ContactPhone> findByUseridandContactId( @Param("userid") Long userid,  @Param("contactId") Long contactId);
}
