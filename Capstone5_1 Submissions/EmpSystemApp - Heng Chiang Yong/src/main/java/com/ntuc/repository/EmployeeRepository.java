package com.ntuc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ntuc.model.employee;

public interface EmployeeRepository extends JpaRepository<employee, Integer>{
	@Query("SELECT p FROM employee p WHERE "
			+ " CONCAT(p.id, p.firstname, p.lastname, p.email, p.phone, p.jobid, p.deptid, p.salary)" 
			+  " LIKE %?1%" )
	public Page<employee> findAll(String keyword,Pageable pageable);
}
