package com.hresource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hresource.model.Department;
import com.hresource.model.Employee;
import com.hresource.repository.DepartmentRepository;
import com.hresource.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private DepartmentRepository catrepo;
	
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<Employee> listEmployees = repo.findAll();
		model.addAttribute("listEmployees",listEmployees);
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String showNewEmployeeForm(Model model) {
		List<Department> listDepartments =  catrepo.findAll();
		model.addAttribute("employee", new Employee());
		model.addAttribute("listDepartments",listDepartments);
		return "employee_form";
		
	}
	@PostMapping("/employees/save")
	public String saveEmployee(Employee employee, HttpServletRequest request) {
		String[] detailIDs = request.getParameterValues("detailID");
		String[] detailNames = request.getParameterValues("detailName");
		String[] detailValues = request.getParameterValues("detailValue");
		
		for (int i = 0; i< detailNames.length; i++) {
			if(detailIDs != null && detailIDs.length > 0)
				employee.setDetails(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
			else {
				employee.addDetail(detailNames[i], detailValues[i]);
		}
		}
		repo.save(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String ShowEmplopyeeEditForm(@PathVariable("id") Integer id, Model model) {
		Employee employee = repo.findById(id).get();
		model.addAttribute("employee", employee);
		List<Department> listDepartments = catrepo.findAll();
		model.addAttribute("listDepartments", listDepartments);
		return "employee_form";
		
	}
	
	@GetMapping("/employees/delete/{id}")
	public String ShowEmployeeDeleteForm(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);
		return "redirect:/employees";
	}
	

}
