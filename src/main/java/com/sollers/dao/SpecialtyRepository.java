package com.sollers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sollers.model.Specialty;

@Repository
public interface SpecialtyRepository  extends JpaRepository<Specialty, Integer>
{

}
