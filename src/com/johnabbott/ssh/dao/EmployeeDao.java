package com.johnabbott.ssh.dao;

import java.util.List;

import com.johnabbott.ssh.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees(); // SELECT

	public Employee getEmployee(int id); // SELECT

	int addEmployee(Employee employee); // INSERT

	public boolean deleteEmployee(int id); // DELETE

	public boolean editEmployee(Employee employee); // UPDATE

}
