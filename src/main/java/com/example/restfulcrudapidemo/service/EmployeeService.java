package com.example.restfulcrudapidemo.service;

import com.example.restfulcrudapidemo.entity.Employee;
import com.example.restfulcrudapidemo.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    void add(EmployeeModel employeeModel);

    List<Employee> getAllEmployee();

    Employee getOneEmployee(String name);
    Employee getById(int id);
    void deleteEmployee(Integer id);
    Employee updateEmployee(EmployeeModel employeeModel);
}
