package com.johnabbott.ssh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.ssh.dao.EmployeeDao;
import com.johnabbott.ssh.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	List<Employee> listEmployees;

	public EmployeeServiceImpl() {
		listEmployees = new ArrayList<Employee>();

		listEmployees.add(new Employee(1, "firstName1", "lastName1", "email1"));
		listEmployees.add(new Employee(2, "firstName2", "lastName2", "email2"));
		listEmployees.add(new Employee(3, "firstName3", "lastName3", "email3"));
		listEmployees.add(new Employee(4, "firstName4", "lastName4", "email4"));
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee) > 0;
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public boolean editEmployee(Employee employee) {
		return employeeDao.editEmployee(employee);
	}
}
