package com.example.backend.Service;

import com.example.backend.Model.Employee;

public interface IEmployeeService {
	Employee findEmployeeByEmail(Employee employee) throws Exception;
}
