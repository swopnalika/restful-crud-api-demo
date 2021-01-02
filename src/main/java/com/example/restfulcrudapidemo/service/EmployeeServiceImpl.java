package com.example.restfulcrudapidemo.service;

import com.example.restfulcrudapidemo.entity.Employee;
import com.example.restfulcrudapidemo.model.EmployeeModel;
import com.example.restfulcrudapidemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void add(EmployeeModel employeeModel) {

        Employee employee = new Employee();
        employee.setName(employeeModel.getName());
        employee.setDepartment(employeeModel.getDepartment());
        employee.setContact_no(employeeModel.getContact_no());
        try {
            employee.setDoj(new Timestamp(simpleDateFormat.parse(employeeModel.getDoj()).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setAddress(employeeModel.getAddress());
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneEmployee(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee getById(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
   public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(EmployeeModel employeeModel) {
        Employee existingEmployee = employeeRepository.findById(employeeModel.getId()).orElse(null);
        existingEmployee.setName(employeeModel.getName());
        existingEmployee.setDepartment(employeeModel.getDepartment());
        existingEmployee.setContact_no(employeeModel.getContact_no());
        existingEmployee.setAddress(employeeModel.getAddress());
        try {
            existingEmployee.setDoj(new Timestamp(simpleDateFormat.parse(employeeModel.getDoj()).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employeeRepository.save(existingEmployee);
    }

}
