package com.sollers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Specialty;
import com.sollers.service.SpecialtyService;

@RestController
public class SpecialtyController 
{
	 @Autowired
	    private SpecialtyService specialtyService;

	    @GetMapping("/specialties")
	    public ResponseEntity < List < Specialty >> getAllSpecialty() {
	        return ResponseEntity.ok().body(specialtyService.getSpecialties());
	    }

	    @GetMapping("/specialties/{id}")
	    public ResponseEntity < Specialty > getSpecialtyById(@PathVariable int id) throws RecordNotFoundException 
	    {
	        return ResponseEntity.ok().body(specialtyService.getSpecialtyByID(id));
	    }

	    @PostMapping("/specialties")
	    public ResponseEntity < Specialty > createSpecialty(@RequestBody Specialty specialty) 
	    {
	        return ResponseEntity.ok().body(this.specialtyService.saveNewSpecialty(specialty));
	    }

	    @PutMapping("/specialties/{id}")
	    public ResponseEntity < Specialty > updateSpecialty(@PathVariable int id, @RequestBody Specialty specialty) throws RecordNotFoundException 
	    {
	    	specialty.setId(id);
	        return ResponseEntity.ok().body(this.specialtyService.updateSpecialty(specialty));
	    }

	    @DeleteMapping("/specialties/{id}")
	    public HttpStatus deleteSpecialty(@PathVariable int id) throws RecordNotFoundException 
	    {
	        this.specialtyService.deleteSpecialty(id);
	        return HttpStatus.OK;
	    }
	    
	    @DeleteMapping("/specialties")
	    public HttpStatus deleteAllSpecialties() 
	    {
	        this.specialtyService.deleteAllSpecialties();
	        return HttpStatus.OK;
	    }
	    
}
