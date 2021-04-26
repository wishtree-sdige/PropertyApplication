package com.property.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@Entity
@Table(name = "property")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Property extends BaseModel {
	/**
	 * serial version id used while serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Auto generated id used as primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String propertyName;
	private String additionalInfo;
	private String propertyType;
	private String noOfRooms;
	private String contactemail;
	private int mobileNumber;
	private double price;
	private String city;	
	private String state;	
	private String zipcode;
	private boolean approve;
}
