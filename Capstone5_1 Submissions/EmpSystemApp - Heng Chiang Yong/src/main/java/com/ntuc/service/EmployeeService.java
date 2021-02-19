package com.ntuc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ntuc.model.employee;
import com.ntuc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	public Page<employee> listAll(int pageNumber, String sortField, String sortDir, String keyword){
		
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Pageable pageable = PageRequest.of(pageNumber-1, 5,sort);
		
		if(keyword!=null) {
		return empRepo.findAll(keyword,pageable);
		}
		return empRepo.findAll(pageable);
	}
	
	public void save(employee emp) {
		
		empRepo.save(emp);
	}
	
	public employee get(Integer id) {
		return empRepo.findById(id).get();
	}
	
	public void delete(Integer id) {
		empRepo.deleteById(id);
	}
	

}
