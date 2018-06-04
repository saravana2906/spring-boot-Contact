package com.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.contacts.entity.Contact;
import com.contacts.entity.ContactPhone;
import com.contacts.entity.User;
import com.contacts.repository.ContactPhoneRepository;
import com.contacts.repository.ContactRepository;
import com.contacts.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ContactsManagementApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(ContactsManagementApplication.class, args);
		log.info("Application started ");
	}
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	ContactPhoneRepository contactPhoneRepository;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//jdbcTemplate.query("select * from users",(rs,rownum)->new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5))).forEach(u->log.info(u.toString()));
		User user=new User();
		user.setUsername("saravana");
		user.setEmailid("sars@gmail.com");
		user.setPassword("sars");
		user.setPhoneno("9442523311");
		log.info("Goint to save user ");
		user=userRepository.save(user);
		System.out.println("User id :"+ user.getUserid());
		Contact contact=new Contact();
		contact.setName("aruna");
		contact.setEmailId("aruna@gmail.com");
		contact.setUser(user);
		contact=contactRepository.save(contact);
		System.out.println("Contac ID "+contact.getContactId());
		ContactPhone contactPhone=new ContactPhone();
		contactPhone.setPhoneNo("9442623311");
		contactPhone.setContact(contact);
		contactPhoneRepository.save(contactPhone);
		System.out.println("Phone ID :"+contactPhone.getPhoneID());
		Contact test=new Contact();
		User tuser=new User();
		tuser.setUserid(1L);
		test.setEmailId("siva@gmail.com");
		test.setName("siva");
		test.setUser(tuser);
		log.info("Testing partiality");
		test=contactRepository.save(test);
		
		
		
	}
	
}
