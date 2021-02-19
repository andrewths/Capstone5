package com.hresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hresource.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
