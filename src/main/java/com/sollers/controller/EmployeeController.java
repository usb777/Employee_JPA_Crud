package com.sollers.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Employee;

import com.sollers.service.EmployeeService;



@RestController
public class EmployeeController 
{
	
	
	 @Autowired
	    private EmployeeService employeeService;
	 
	 @Autowired
	 RestTemplate restTemplate; 

	 /*
	 @GetMapping("/employees")
	    public ResponseEntity < List < Employee >> getAllEmployees() {
	        return ResponseEntity.ok().body(employeeService.getEmployees());
	    }
	   */
	
	    @GetMapping(path="/employees", headers="X-version=v1")
	    public ResponseEntity < List < Employee >> getAllEmployees() {
	        return ResponseEntity.ok().body(employeeService.getEmployees());
	    }
	    
	    
	    @GetMapping(path="/employees",  headers="X-version=v2")
	    public ResponseEntity < Employee > getAllEmployeesV2() throws RecordNotFoundException 
	    {
	    	return ResponseEntity.ok().body(employeeService.getEmployeeByID(1));
	    }
	    
	  
	    
	    
	    @GetMapping(value = "/amazon/employees")
	    private String getEmployeesRT()
	    {
	    		       
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.add("X-version", "v1");
	    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    	HttpEntity<String> entity = new HttpEntity<String>(headers);
	    	
	    	return restTemplate.exchange("http://localhost:8080/employees",HttpMethod.GET,entity,String.class).getBody();
	    	
	    }
	        
	    

	    @GetMapping("/employees/{id}")
	    public ResponseEntity < Employee > getEmployeeById(@PathVariable int id) throws RecordNotFoundException 
	    {
	        return ResponseEntity.ok().body(employeeService.getEmployeeByID(id));
	    }
	    
	    
	    
	    

	    @PostMapping("/employees")
	    public ResponseEntity < Employee > createEmployee(@RequestBody Employee employee) 
	    {
	        return ResponseEntity.ok().body(this.employeeService.saveNewEmployee(employee));
	    }

	    @PutMapping("/employees/{id}")
	    public ResponseEntity < Employee > updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws RecordNotFoundException 
	    {
	    	employee.setId(id);
	        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	    }
	    
	    
	    
	    @RequestMapping(value = "/amazon/employees/{id}", method = RequestMethod.PUT)
	    public String updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) {
	       HttpHeaders headers = new HttpHeaders();
	       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	       HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
	       
	       return restTemplate.exchange("http://localhost:8080/employees/"+id, HttpMethod.PUT, entity, String.class).getBody();
	    }
	    
	    
	    
	    
	  
	    
	    
	    
	    
	    
	    

	    @DeleteMapping("/employees/{id}")
	    public HttpStatus deleteEmployee(@PathVariable int id) throws RecordNotFoundException 
	    {
	        this.employeeService.deleteEmployee(id);
	        return HttpStatus.OK;
	    }
	    
	      
	    	    
	    
	    @DeleteMapping("/employees")
	    public HttpStatus deleteAllEmployees() 
	    {
	        this.employeeService.deleteAllEmployees();
	        return HttpStatus.OK;
	    }
	    

}
