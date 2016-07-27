/**
 * 
 */
package com.kant.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shaskant
 *
 */
@ApiModel(value = "Person", description = "stores person details")
@XmlRootElement
public class Person {
	@XmlElement
	@ApiModelProperty(position = 1, required = true, value = "user's firstname containing only lowercase letters")
	private String firstName;
	@XmlElement
	@ApiModelProperty(position = 2, required = true, value = "user's last name containing only lowercase letters")
	private String lastName;
	@XmlElement
	@ApiModelProperty(position = 3, required = true, value = "email id ")
	private String emailId;
	@XmlElement
	@ApiModelProperty(position = 4, required = true, value = "phone number")
	private String phone;
	@XmlElement
	@ApiModelProperty(position = 5, required = true, value = "user's age")
	private Integer age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
