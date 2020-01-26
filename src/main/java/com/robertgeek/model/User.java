package com.robertgeek.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//@ApiModel(description = "All details about the user.")
public class User {

	private Integer id;
	
	@Size(min = 2, message = "The name should have at least 2 Characters")
	//@ApiModelProperty(notes="The name should have at least 2 Characters")
	private String  name;
	
	@Past(message = "The date will be in the past")
	//@ApiModelProperty(notes="Birth date should be in the past")
	private Date    birthDay;

	public User() {
		super();
	}

	public User(Integer id, String name, Date birthDay) {
		super();
		this.id       = id;
		this.name     = name;
		this.birthDay = birthDay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

}
