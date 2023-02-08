package com.example.backend.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.Model.Employee;
import com.example.backend.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployee() throws Exception{
        return employeeService.findAllEmployees();
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee) throws Exception{
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping(path="/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) throws Exception{
        return this.employeeService.findEmployeeById(id);
    }
    
    @PutMapping(path="/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) throws Exception{
        try {
            return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/{email}")
    public ResponseEntity<?> getEmployeeByEmail(@PathVariable("email") Employee employee)throws Exception{
        try {
            return new ResponseEntity<Employee>(employeeService.findEmployeeByEmail(employee), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
