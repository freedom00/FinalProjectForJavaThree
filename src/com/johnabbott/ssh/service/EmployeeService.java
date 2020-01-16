package com.johnabbott.ssh.service;

import java.util.List;

import com.johnabbott.ssh.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees(); // SELECT

	public Employee getEmployee(int id); // SELECT

	public boolean addEmployee(Employee employee); // INSERT

	public boolean deleteEmployee(int id); // DELETE

	public boolean editEmployee(Employee employee); // UPDATE
}
