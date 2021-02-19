package com.hresource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hresource.model.*;
import com.hresource.repository.*;

@Controller
public class DepartmentController<DepartmentController> {
	
	@Autowired
	private DepartmentRepository repo;
	
	@GetMapping("/departments")
	public String listDepartments(Model model) {
		List<Department> listdepartments = repo.findAll();
		model.addAttribute("listdepartments",listdepartments);
		return "departments";
	}
	
	@GetMapping("/departments/new")
	public String ShowCategoryNewForm(Model model) {
		model.addAttribute("department", new Department());
		
		return "department_form";
						
	}
	
	@PostMapping("/departments/save")
	public String saveCategory(Department department) {
		repo.save(department);
		return "redirect:/departments";
	}
	
	
	@GetMapping("/departments/back")
	public String BackDepartments(){
		return "index";
	}
	
	
	
}
