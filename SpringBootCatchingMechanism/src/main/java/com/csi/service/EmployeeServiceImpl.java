package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Cacheable(value = "empId")
    public Optional<Employee> findById(int empId) {
        log.info("@@@@@@@TRYING TO FETCH DATA FROM DB########");
        return employeeRepo.findById(empId);
    }

    public Optional<Employee> findByContactNumber(long empContactNumber) {
        return employeeRepo.findByEmpContactNumber(empContactNumber);
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepo.deleteById(empId);
    }

    public void deleteAll() {
        employeeRepo.deleteAll();
    }
}
