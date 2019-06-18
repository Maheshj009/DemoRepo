package com.scp.mvc.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.mvc.beans.Employee;
import com.scp.mvc.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService employeeService;
	
	

	public EmpService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmpService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee")Employee emp, 
			BindingResult result) {
		System.out.println("save emp invoked"+emp);
		if(emp.getEmpId()>0) {
			employeeService.updateEmployee(emp);
		}else {
			employeeService.addEmployee(emp);
		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		System.out.println("list emp invoked");
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")Employee Employee,
			BindingResult result) {
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("employee", new Employee());
		model.put("employees", employeeService.getAllEmployees());
		return new ModelAndView("addemployee",model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("welcome emp invoked");
		return new ModelAndView("addemployee");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("id") int empId) {
		System.out.println("Inside delete method ..." + empId);
		employeeService.deleteEmployee(empId);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable("id") int empId) {
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("employee", employeeService.getEmployee(empId));
		model.put("employees", employeeService.getAllEmployees());
		return new ModelAndView("addemployee",model);
	}


}

