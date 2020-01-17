package com.johnabbott.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.ssh.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		sessionFactory.getCurrentSession().save(employee.getDepartment());
		return 1;
	}

	@Override
	public List<Employee> getEmployees() {
		return getSession().createQuery("from Employee", Employee.class).list();
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	@Override
	public boolean deleteEmployee(int studentId) {
		Employee fetchedEmployee = getEmployee(studentId);
		getSession().delete(fetchedEmployee);
		return true;
	}

	@Override
	public boolean editEmployee(Employee employee) {		
		getSession().update(employee);
		getSession().update(employee.getDepartment());
		return true;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
