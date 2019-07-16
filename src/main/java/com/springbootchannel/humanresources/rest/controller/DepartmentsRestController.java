package com.springbootchannel.humanresources.rest.controller;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.domain.Department;
import com.springbootchannel.humanresources.repository.CompanyRepository;
import com.springbootchannel.humanresources.repository.DepartmentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/departments")
@Api(tags = "Departments" ,description = "Departments Services")
public class DepartmentsRestController {

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;

    public DepartmentsRestController(CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    @ApiOperation(value = "Departments List" )
    public List<Department> getAllDepartments(){

        return departmentRepository.findAll();
    }
    @ApiOperation(value = "Get Department by ID"  )
    @GetMapping("{departmentId}")
    private Department getDepartmentById(@PathVariable Long departmentId){
        return departmentRepository.findById(departmentId).orElseThrow(()->
                new NoSuchElementException("Can not find Department with ID : " + departmentId));
    }

    @PostMapping
    @ApiOperation(value = "Add New Department" )
    public Department addNewDepartment(@RequestBody Department department ){

        return departmentRepository.save(department);
    }

}
