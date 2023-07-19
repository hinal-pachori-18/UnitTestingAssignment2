package com.example.PayRollService.service;

import com.example.PayRollService.entity.Employee;
import com.example.PayRollService.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee1, employee2;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee1 = new Employee(2, "Divit", 90000);
        employee2 = new Employee(3, "Hinal", 3430000);
        employeeList.add(employee1);
        employeeList.add(employee2);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testGetAllEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findAll()).thenReturn(employeeList);
        assertThat(employeeService.getAllEmployee()).isEqualTo(employeeList);
        System.out.println(employeeList);

    }

    @Test
    void testGetEmployeeByName() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findByName("Divit")).thenReturn(
                new ArrayList<Employee>(Collections.singleton(employee1))
        );
        assertThat(employeeService.getEmployeeByName("Divit").get(0)).isEqualTo(employee1);
        System.out.println(employee1);
    }

    @Test
    void testGetEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findById(2)).thenReturn(Optional.ofNullable(employee1));
        assertThat(employeeService.getEmployeeById(2)).isEqualTo(employee1);

    }

    @Test
    void testAddEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.save(employee1)).thenReturn(employee1);
        assertThat(employeeService.addEmployee(employee1)).isEqualTo(employee1);
        System.out.println(employee1);
    }

    @Test
    void testUpdateEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findById(2)).thenReturn(Optional.ofNullable(employee1));
        when(employeeRepository.save(employee1)).thenReturn(employee1);
        assertThat(employeeService.updateEmployee(2, employee1)).isEqualTo(employee1);
        System.out.println(employee1);
    }

    @Test
    void testDeleteEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);
        when(employeeRepository.findById(2)).thenReturn(Optional.ofNullable(employee1));
        doNothing().when(employeeRepository).deleteById(2);
        assertThat(employeeService.deleteEmployee(2)).isEqualTo("Successfully deleted");
    }
}
