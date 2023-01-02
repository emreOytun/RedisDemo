package com.emreoytun.microservices.redisdemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Entities must be Serializable to use Redis Data. */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7690102271231639624L;
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private int age;
	
}
