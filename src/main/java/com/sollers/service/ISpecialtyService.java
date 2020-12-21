package com.sollers.service;

import java.util.List;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Specialty;

public interface ISpecialtyService 
{

	 public List<Specialty> getSpecialties();
	  public Specialty getSpecialtyByID(int id)throws RecordNotFoundException;
	  public Specialty saveNewSpecialty(Specialty specialty);
	  public Specialty updateSpecialty(Specialty specialty)throws RecordNotFoundException;
	  public void deleteSpecialty(int id) throws RecordNotFoundException ;
	  public void deleteAllSpecialties();
	
}
