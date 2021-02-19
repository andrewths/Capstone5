package com.ntuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntuc.model.department;

public interface DepartmentRepository extends JpaRepository<department, Integer>{

}
