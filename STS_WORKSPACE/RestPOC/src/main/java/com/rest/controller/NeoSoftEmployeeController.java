package com.rest.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.exception.ResourceNotFoundException;
import com.rest.model.NeoSoftEmployee;
import com.rest.repository.NeoSoftEmployeeRepository;

@RestController
public class NeoSoftEmployeeController {

	@Autowired
	private NeoSoftEmployeeRepository neoSoftEmployeeRepository;

	// Method to fetch all employee data
	@GetMapping("/employees")
	@ResponseBody
	public List<NeoSoftEmployee> getEmployee() {
		return neoSoftEmployeeRepository.findAll();

	}

	// Method to fetch employee data from database based on id
	@GetMapping("/employees/{id}")
	public Optional<NeoSoftEmployee> getEmployeeById(@PathVariable("id") Long id) {
		// System.out.println("In Method
		// getAllNeoSoftEmp"+neoSoftEmployeeRepository.findAll());
		return neoSoftEmployeeRepository.findById(id);

	}

	// Method to fetch employee data from database based on surname
	@GetMapping("/employees/surname/{surName}")
	@ResponseBody
	public List<NeoSoftEmployee> getEmployeeBySurname(@PathVariable("surName") String surName) {
		System.out.println("find by surName" + surName);
		return neoSoftEmployeeRepository.findBysurName(surName);

	}

	// Method to fetch employee from database data based on name
	@GetMapping("/employees/name/{name}")
	public List<NeoSoftEmployee> getEmployeeByName(@PathVariable("name") String name) {
		System.out.println("find by surName" + name);
		return neoSoftEmployeeRepository.findByName(name);

	}

	// Method to fetch employee data from database based on pin code
	@GetMapping("/employees/pincode/{pincode}")
	public List<NeoSoftEmployee> getEmployeeByPincode(@PathVariable("pincode") String pincode) {
		System.out.println("find by pinCode" + pincode);
		return neoSoftEmployeeRepository.findBypinCode(pincode);

	}

	// Method to save employee data to database
	@PostMapping(path = "/employees", consumes = { "application/json" })
	public NeoSoftEmployee saveEmployee(@RequestBody NeoSoftEmployee emp) {
		neoSoftEmployeeRepository.save(emp);
		return emp;
	}

	// Method to update employee data to database
	@PutMapping(path = "/employees/{id}", consumes = { "application/json" })
	public NeoSoftEmployee updateEmployee(@PathVariable("id") Long id,
			@Validated @RequestBody NeoSoftEmployee empDetails) {
		NeoSoftEmployee employee = neoSoftEmployeeRepository.getOne(id);
		employee.setName(empDetails.getName());
		employee.setSurName(empDetails.getSurName());
		employee.setEmailId(empDetails.getEmailId());
		employee.setAadharNo(empDetails.getAadharNo());
		employee.setContactNo(empDetails.getContactNo());
		employee.setPassportNo(empDetails.getPassportNo());
		employee.setPinCode(empDetails.getPinCode());
		employee.setActiveFlag(empDetails.getActiveFlag());
		employee.setDOB(empDetails.getDOB());
		employee.setJoiningDate(empDetails.getJoiningDate());
		NeoSoftEmployee updatedEmp = neoSoftEmployeeRepository.save(employee);
		return updatedEmp;
	}

	// Method to delete employee data from dadtabase based on id
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		NeoSoftEmployee emp = neoSoftEmployeeRepository.getOne(id);
		neoSoftEmployeeRepository.delete(emp);
		return "Data Deleted";
	}


	// Method to update employee data to database
	@PutMapping(path = "/employees/softdelete/{id}")
	public NeoSoftEmployee softDelete(@PathVariable("id") Long id, @Validated @RequestBody NeoSoftEmployee empDetails) {
		NeoSoftEmployee employee = neoSoftEmployeeRepository.getOne(id);
		employee.setActiveFlag(1);
		NeoSoftEmployee updatedEmp = neoSoftEmployeeRepository.save(employee);
		return updatedEmp;
	}

	// Method to fetch employee data based on birth date sorting ascending order
	@GetMapping("/employees/dobsort")
	public List<NeoSoftEmployee> getEmployeeDobSort() {
		List<NeoSoftEmployee> employee = neoSoftEmployeeRepository.findAll();

		Comparator<NeoSoftEmployee> byDOB = (c1, c2) -> {
			if (c1.getDOB().before(c2.getDOB()))
				return -1;
			else
				return 1;
		};

		List<NeoSoftEmployee> sortedEmployee = employee.stream().sorted(byDOB).collect(Collectors.toList());

		System.out.println(sortedEmployee);
		return sortedEmployee;
	}

	// Method to fetch employee data based on joining date sorting ascending order
	@GetMapping("/employees/jdsort")
	public List<NeoSoftEmployee> getEmployeJoiningdateSort() {
		List<NeoSoftEmployee> employee = neoSoftEmployeeRepository.findAll();

		Comparator<NeoSoftEmployee> byJD = (c1, c2) -> {
			if (c1.getJoiningDate().before(c2.getJoiningDate()))
				return -1;
			else
				return 1;
		};

		List<NeoSoftEmployee> sortedEmployee = employee.stream().sorted(byJD).collect(Collectors.toList());

		System.out.println(sortedEmployee);
		return sortedEmployee;
	}

}
