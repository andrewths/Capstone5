package com.hresource;
import com.hresource.model.Employee;
import com.hresource.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hresource.service.EmployeeService;

@Controller
public class AppController {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		String keyword = null;
		return listByPage(model,1, "name", "asc",keyword);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword)	{
		Page<Employee> page = service.listAll(currentPage,sortField,sortDir,keyword);
		Long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "index";
	}
	
	
	@RequestMapping("/new")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeeForm(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_employee");
		
		Employee employee = service.get(id);
		mav.addObject("employee", employee);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id) {
		service.delete(id);
		
		return "redirect:/";
	}
}
