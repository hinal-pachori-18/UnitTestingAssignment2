package com.example.PayRollService.repository;

import com.example.PayRollService.entity.Employee;
import com.example.PayRollService.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);

}
