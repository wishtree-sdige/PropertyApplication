package com.property.application.VO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class PropertyVO {
	@NotNull(message = "{id.not-null}")
	@NotEmpty
	private Long id;
	@NotNull(message = "{propertyName.not-null}")
	@NotEmpty
	private String propertyName;
	private String additionalInfo;
	@NotNull(message = "{propertyType.not-null}")
	@NotEmpty
	private String propertyType;
	private String noOfRooms;
	private double price;
	@NotNull(message = "{city.not-null}")
	private String city;	
	private String state;	
	private String zipcode;
	@NotNull(message = "{mobile.not-null}")
    @Size(min=10, max=13, message = "{mobile.size}")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="{mobile.pattern}")
	private int mobileNumber;
	@NotNull(message = "{email.not-null}")
	@NotEmpty
	@Email
	private String contactemail;
	private String status;

}
