package com.johnabbott.ssh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.johnabbott.ssh.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"),
				rs.getString("email"));
	}

}
