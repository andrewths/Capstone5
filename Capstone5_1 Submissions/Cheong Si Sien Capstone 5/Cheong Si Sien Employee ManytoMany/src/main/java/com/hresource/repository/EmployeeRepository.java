package com.hresource.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hresource.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
//	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//			+ " OR p.tel LIKE %?1%"
//			+ " OR p.departmentid LIKE %?1%")
//	public List<Employee> findAll(String keyword);
	
	@Query("SELECT e FROM Employee e WHERE "
			+ " CONCAT(e.id, e.name, e.tel, e.departmentid)" 
			+  " LIKE %?1%" )
	public Page<Employee> findAll(String keyword,Pageable pageable);
	
}
