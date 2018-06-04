package com.contacts.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class ContactPhone {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long phoneID;
	private String phoneNo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;

}
