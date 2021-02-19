package com.hresource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hresource.model.Employee;
import com.hresource.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
//	public List<Employee> listAll(String keyword) {
//		
//		if (keyword !=null) {
//			return repo.findAll(keyword);
//		}
//		return repo.findAll();
//	}
	
	public Page<Employee> listAll(int pageNumber, String sortField, String sortDir, String keyword){
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Pageable pageable = PageRequest.of(pageNumber-1, 5,sort);
		if(keyword!=null) {
		return repo.findAll(keyword,pageable);
		}
		return repo.findAll(pageable);
			
	}
	
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	public Employee get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
