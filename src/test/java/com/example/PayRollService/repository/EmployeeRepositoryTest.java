package com.example.PayRollService.repository;

import com.example.PayRollService.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest

public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
     void setUp() {
        employee = new Employee(0,"Lavish",20000);
        employeeRepository.save(employee);
    }

    @AfterEach
    void tearDown()
    {
        employee=  null;
        employeeRepository.deleteAll();
    }

    //Test case Success
    @Test
    void testFindByName_Found(){
         List<Employee> getEmployee = employeeRepository.findByName("Lavish");
         assertThat(getEmployee.get(0).getId()).isEqualTo(employee.getId());
         assertThat(getEmployee.get(0).getName()).isEqualTo(employee.getName());
    }

    @Test
    void testFindByName_NotFound()
    {
        List<Employee> getEmployee = employeeRepository.findByName("Kinnari");
        assertThat(getEmployee.isEmpty()).isTrue();
    }

    //Test case failure
}
