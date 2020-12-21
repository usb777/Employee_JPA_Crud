package com.sollers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sollers.dao.SpecialtyRepository;
import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Specialty;

@Service
@Transactional
public class SpecialtyService implements ISpecialtyService
{
	
	@Autowired
    private SpecialtyRepository specialtyRepository;
	
	
	@Override
	 public List<Specialty> getSpecialties()
	 {
		 return this.specialtyRepository.findAll();
	 }
	 
	 
	@Override
	  public Specialty getSpecialtyByID(int specialtyId) throws RecordNotFoundException
	  {
		  Optional < Specialty > specialtyDb = this.specialtyRepository.findById(specialtyId);

	        if (specialtyDb.isPresent()) {
	            return specialtyDb.get();
	        } 
	        else 
	        {       
	        	throw new RecordNotFoundException("Record not found with id : " + specialtyId);   
	        }
	  }
	  
	  
	@Override
	  public Specialty saveNewSpecialty(Specialty specialty)
	  {
		  return specialtyRepository.save(specialty);
	  }
	  
	  
	@Override
	  public Specialty updateSpecialty(Specialty specialty) throws RecordNotFoundException
	  {
		  Optional < Specialty > productDb = this.specialtyRepository.findById(specialty.getId());

	        if (productDb.isPresent()) {
	        	Specialty specialtyUpdate = productDb.get();
	        	specialtyUpdate.setId(specialty.getId());
	        	specialtyUpdate.setName(specialty.getName());
	        
	        	specialtyRepository.save(specialtyUpdate);
	            return specialtyUpdate;
	        } else {
	            throw new RecordNotFoundException("Record not found with id : " + specialty.getId());
	        }
	  }
	  
	@Override
	  public void deleteSpecialty(int specialtyId) throws RecordNotFoundException
	  {
		Optional < Specialty > productDb = this.specialtyRepository.findById(specialtyId);

        if (productDb.isPresent()) {
            this.specialtyRepository.delete(productDb.get());
            
        } else {
            throw new RecordNotFoundException("Record not found with id : " + specialtyId);
        }

	  }
	
	
	@Override
	  public void deleteAllSpecialties() 
	  {
		
          this.specialtyRepository.deleteAll();

	  }
	  
	
	
	  

}
