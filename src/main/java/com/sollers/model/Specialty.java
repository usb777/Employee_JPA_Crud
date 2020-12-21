package com.sollers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Specialty 
{

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	
	@Column
	private String name;
	

	public Specialty() 
	{	
		super();		
	}



	public Specialty(int id, String name) 
	{
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() 
	{	return "Specialty [id=" + id + ", name=" + name + "]";	}
	
	
}
