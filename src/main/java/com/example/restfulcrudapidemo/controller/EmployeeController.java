package com.example.restfulcrudapidemo.controller;


import com.example.restfulcrudapidemo.entity.Employee;
import com.example.restfulcrudapidemo.model.EmployeeModel;
import com.example.restfulcrudapidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("addEmployee")
    public void addEmployee(@RequestBody EmployeeModel employeeModel) {
        employeeService.add(employeeModel);
    }

    @GetMapping("getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @GetMapping("getOneEmployee")
    public Employee getOneEmployee(@RequestParam String name) {
        return employeeService.getOneEmployee(name);
    }

    @GetMapping("getById")
    public Employee getById(@RequestParam int id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("deleteEmployee")
    public void deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("updateEmployee")
    public Employee updateEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeService.updateEmployee(employeeModel);
    }

}

