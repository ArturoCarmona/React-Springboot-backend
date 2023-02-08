package com.example.backend.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.Model.Employee;
import com.example.backend.Repository.IEmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    IEmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() throws Exception{
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) throws Exception{
        Employee employee = employeeRepository.findById(id)
            .orElseThrow( () -> new IllegalStateException("The employee id "+id+" does not exist."));
        return employee;
    }

    public Employee saveEmployee(Employee employee) throws Exception{
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, Long id) throws Exception{
        Employee employeeDB = findEmployeeById(id);
        employeeDB.setFirstName(employee.getFirstName());
        employeeDB.setLastName(employee.getLastName());
        employeeDB.setEmail(employee.getEmail());
        return saveEmployee(employeeDB);
    }

    public String deleteEmployee(Long id){
        try {
            employeeRepository.deleteById(id);
            return "The employee has been deleted";
        } catch (Exception e) {
            return "The employee has not been deleted";
        }
    }

    public Employee findEmployeeByEmail(Employee employee) throws Exception {
        Employee emailEmployee = employeeRepository.findByEmail(employee.getEmail());
        return emailEmployee;
    }
}
