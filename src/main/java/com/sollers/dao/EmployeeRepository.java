package com.sollers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sollers.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
