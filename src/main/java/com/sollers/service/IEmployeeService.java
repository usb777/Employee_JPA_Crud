package com.sollers.service;

import java.util.List;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Employee;


public interface IEmployeeService 
{

	  public List<Employee> getEmployees();
	  public Employee getEmployeeByID(int id)throws RecordNotFoundException;
	  public Employee saveNewEmployee(Employee employee);
	  public Employee updateEmployee(Employee employee)throws RecordNotFoundException;
	  public void deleteEmployee(int id) throws RecordNotFoundException ;
	  public void deleteAllEmployees();
	
}
