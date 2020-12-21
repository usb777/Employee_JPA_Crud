package com.sollers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.client.RestTemplate;

import com.sollers.exception.RecordNotFoundException;
import com.sollers.model.Employee;

import com.sollers.service.EmployeeService;

@RestController
public class EmployeeController 
{
	
	
	 @Autowired
	    private EmployeeService employeeService;

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
	    
	  
	    

	    @GetMapping("/employees/{id}")
	    public ResponseEntity < Employee > getEmployeeById(@PathVariable int id) throws RecordNotFoundException 
	    {
	        return ResponseEntity.ok().body(employeeService.getEmployeeByID(id));
	    }
	    
	    
	    //get Employee by id through RestTemplate
	    
	    private static void getEmployeeById()
	    {
	        final String uri = "http://localhost:8080/employees/{id}";
	        RestTemplate restTemplate = new RestTemplate();
	         
	        Map<String, String> params = new HashMap<String, String>();
	        params.put("id", "1");
	         
	        Employee emp = restTemplate.getForObject(uri, Employee.class, params);
	         
	        //Use the result
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
	    
	    
	    //update Employee through RestTemplate
	    
	    private static void updateEmployee()
	    {
	        final String uri = "http://localhost:8080/employees/{id}";
	        RestTemplate restTemplate = new RestTemplate();
	         
	        Map<String, String> params = new HashMap<String, String>();
	        params.put("id", "2");
	       
	        Employee updatedEmployee = new Employee(2, "James", "Gosling",1993, true, 3);
	         
	        restTemplate.put ( uri, updatedEmployee, params );
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
