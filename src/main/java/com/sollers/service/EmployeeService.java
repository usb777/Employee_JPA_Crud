package com.sollers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


import com.sollers.dao.EmployeeRepository;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Employee;


@Service
@Transactional
public class EmployeeService implements IEmployeeService 
{
	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	

	@Override	 
	public List<Employee> getEmployees() 
	{
		 return this.employeeRepository.findAll();
	}
	
	
	
	

	@Override
	public Employee getEmployeeByID(int id) throws RecordNotFoundException {
		 Optional < Employee > employeeDb = this.employeeRepository.findById(id);

	        if (employeeDb.isPresent()) {
	            return employeeDb.get();
	        } 
	        else 
	        {       
	        	throw new RecordNotFoundException("Employee not found with id : " + id);   
	        }
	}

	@Override
	public Employee saveNewEmployee(Employee employee) 
	{
		 return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws RecordNotFoundException 
	{
		Optional < Employee > employeeDb = this.employeeRepository.findById(employee.getId());

        if (employeeDb.isPresent()) {
        	Employee employeeUpdate = employeeDb.get();
        	employeeUpdate.setId(employee.getId());
        	employeeUpdate.setFirstName(employee.getFirstName());
        	employeeUpdate.setLastName(employee.getLastName());
        	employeeUpdate.setYearOfBirthday(employee.getYearOfBirthday());
        	employeeUpdate.setSpecialtyId(employee.getSpecialtyId());
        	employeeUpdate.setStatus(employee.isStatus());
        	
        	
        
        	employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        } else {
            throw new RecordNotFoundException("Record not found with id : " + employee.getId());
        }
	}
	

	@Override
	public void deleteEmployee(int id) throws RecordNotFoundException
	{
		Optional < Employee > productDb = this.employeeRepository.findById(id);

        if (productDb.isPresent()) {
            this.employeeRepository.delete(productDb.get());
            
        } else {
            throw new RecordNotFoundException("Record not found with id : " + id);
        }

	}

	@Override
	public void deleteAllEmployees() {
		this.employeeRepository.deleteAll();
	}

}
