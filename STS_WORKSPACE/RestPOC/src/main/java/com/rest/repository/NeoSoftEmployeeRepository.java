package com.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.NeoSoftEmployee;

public interface NeoSoftEmployeeRepository  extends JpaRepository<NeoSoftEmployee, Long>{

	List<NeoSoftEmployee> findBysurName(String surName);

	List<NeoSoftEmployee> findByName(String name);

	List<NeoSoftEmployee> findBypinCode(String pincode);


	
}
