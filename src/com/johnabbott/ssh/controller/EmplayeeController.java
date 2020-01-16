package com.johnabbott.ssh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.ssh.entity.Employee;
import com.johnabbott.ssh.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmplayeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		System.out.println("getEmployees");
		ModelAndView modelAndView = new ModelAndView("get_employees");

		List<Employee> employees = employeeService.getEmployees();
		modelAndView.addObject("employees", employees);
		modelAndView.addObject("employee", new Employee());

		return modelAndView;
	}

	@RequestMapping(value = "addEmployee")
	public ModelAndView addEmployee() {
		System.out.println("addEmployee");
		ModelAndView mv = new ModelAndView("add_employee");
		mv.addObject("employee", new Employee());
		return mv;
	}

	@RequestMapping(value = "saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("saveEmployee");
		if (employeeService.addEmployee(employee))
			return "redirect:/employees/getEmployees";
		else {
			return "error_page";
		}
	}

	@RequestMapping(value = "deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
		System.out.println("deleteEmployee");
		if (employeeService.deleteEmployee(employeeId)) {
			return "redirect:/employees/getEmployees";
		} else {
			return "error_page";
		}
	}

	@RequestMapping(value = "editEmployee")
	public ModelAndView editEmployee(@RequestParam("employeeId") int employeeId) {
		System.out.println("editEmployee");
		ModelAndView mv = new ModelAndView("edit_employee");
		Employee fetchedEmployee = employeeService.getEmployee(employeeId);
		mv.addObject("editedemployee", fetchedEmployee);
		return mv;
	}

	@RequestMapping(value = "updateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("updateEmployee");
		if (employeeService.editEmployee(employee)) {
			return "redirect:/employees/getEmployees";
		} else {
			return "error_page";
		}
	}

}
