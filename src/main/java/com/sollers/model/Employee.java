package com.sollers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


@Entity
@Table
public class Employee 
{
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	@Column
	private String firstName;
	
	@Size(min=2, message="Lastname should have atleast 2 characters")
	@ApiModelProperty(notes="Lastname should have atleast 2 characters")
	@Column
	private String lastName;
	
	@Column
	private int yearOfBirthday;
	
	@Column
	private int specialtyId;
	
		
	@Column
	private boolean status;
	
	public Employee() 
	{
		super();
		this.specialtyId =1;
	}

	public Employee(int id,  String firstName,	 String lastName,	 int yearOfBirthday,  boolean status, int specialtyId) 
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirthday = yearOfBirthday;
		
		this.status = status;
		this.specialtyId = specialtyId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public int getYearOfBirthday() {
		return yearOfBirthday;
	}


	public void setYearOfBirthday(int yearOfBirthday) {
		this.yearOfBirthday = yearOfBirthday;
	}


	public int getSpecialtyId() {
		return specialtyId;
	}


	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearOfBirthday="
				+ yearOfBirthday + ", specialtyId=" + specialtyId + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
