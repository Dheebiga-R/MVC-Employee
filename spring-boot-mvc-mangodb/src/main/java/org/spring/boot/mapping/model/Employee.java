package org.spring.boot.mapping.model;

import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

//document layer
@Document(collection = "employee")
@Data
@NoArgsConstructor
public class Employee {

	@Id
	private String id;
	
	@CodePointLength(min = 3,max=20)
	@NotBlank(message="Name is manditory")
	private String empName;
	
	@Email(message="Email should be in proper format")
	@NotBlank(message="Email is manditory")
	private String empEmail;
	
	@NotBlank(message="Location is manditory")
	private String empLocation;
}
