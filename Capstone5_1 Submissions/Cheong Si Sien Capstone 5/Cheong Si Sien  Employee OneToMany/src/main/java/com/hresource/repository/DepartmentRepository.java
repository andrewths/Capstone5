package com.hresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hresource.model.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
