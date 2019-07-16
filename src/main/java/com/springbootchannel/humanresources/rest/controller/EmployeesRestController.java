package com.springbootchannel.humanresources.rest.controller;

import com.springbootchannel.humanresources.domain.Department;
import com.springbootchannel.humanresources.domain.Employee;
import com.springbootchannel.humanresources.repository.CompanyRepository;
import com.springbootchannel.humanresources.repository.DepartmentRepository;
import com.springbootchannel.humanresources.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/employees")
@Api(tags = "Employees" ,description = "Employees Services")
public class EmployeesRestController {

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository ;

    public EmployeesRestController(CompanyRepository companyRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    @ApiOperation(value = "Employees List" )
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    @ApiOperation(value = "Get Employees by ID"  )
    @GetMapping("{employeesId}")
    private Employee getEmployeeById(@PathVariable Long employeesId){
        return employeeRepository.findById(employeesId).orElseThrow(()->
                new NoSuchElementException("Can not find Employee with ID : " + employeesId));
    }

    @PostMapping
    @ApiOperation(value = "Add New Employee" )
    public Employee addNewEmployee(@RequestBody Employee employee ){

        return employeeRepository.save(employee);
    }

}
