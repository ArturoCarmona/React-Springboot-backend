package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.Model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByEmail(String email);
}
