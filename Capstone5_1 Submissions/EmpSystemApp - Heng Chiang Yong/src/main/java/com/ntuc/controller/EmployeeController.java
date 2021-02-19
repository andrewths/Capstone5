package com.ntuc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuc.model.department;
import com.ntuc.model.employee;
import com.ntuc.repository.DepartmentRepository;
import com.ntuc.repository.EmployeeRepository;
import com.ntuc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String viewEmployeePage(Model model) {
		String keyword = null;
		return listByPage(model,1,"firstname","asc",keyword);
	}
	
	@GetMapping("/employees/page/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword) {
		Page<employee> page = service.listAll(currentPage,sortField,sortDir,keyword);
		Long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<employee> listemployees = page.getContent();
	//	System.out.println(totalPages);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listEmployees", listemployees);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
	//	model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		System.out.println("total pages = " + totalPages);
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "employees";
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<employee> listemployees = empRepo.findAll();
		model.addAttribute("listEmployees", listemployees);
		return "employees";
	}
	
	@RequestMapping("/new")
	public String NewEmpForm(Model model) {
		employee emp = new employee();
		List<department> listdepartments = deptRepo.findAll();
		model.addAttribute("listDepartments",listdepartments);
		model.addAttribute("employee", emp);
		return "employee_form";
	}
	
	@GetMapping("/employees/new")
	public String showNewEmpForm(Model model) {
		
		List<department> listdepartments = deptRepo.findAll();
		model.addAttribute("listDepartments",listdepartments);
		model.addAttribute("employee", new employee());
		return "employee_form";
	
	}
	
	@PostMapping("/employees/save")
	public String saveEmployee(employee emp, HttpServletRequest request) {
		empRepo.save(emp);
		return "redirect:/";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String EmployeeEditForm(@PathVariable("id")Integer id, Model model) {
		employee emp = empRepo.findById(id).get();
		model.addAttribute("employee", emp);
		List<department> listdept = deptRepo.findAll();
		model.addAttribute("listDepartments", listdept);
		return "employee_form";	
	}
	
	@GetMapping("/employees/delete{id}")
	public String EmployeeDeleteForm(@PathVariable("id") Integer id, Model model) {
		empRepo.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping("/main")
	public String main() {
	    return "main";
	}
	
	@RequestMapping("/index")
	public String index() {
	    return "index";
	}
	
}
