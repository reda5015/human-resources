package com.springbootchannel.humanresources.rest.controller;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.dto.ErrorDto;
import com.springbootchannel.humanresources.repository.CompanyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/companies")
@Api(tags = "Companies" ,description = "Companies Services")
public class companyRestController {

    private final CompanyRepository companyRepository;

    public companyRestController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    @ApiOperation(value = "Companies List" )
    public List<Company> getAllCompanies(){

        return companyRepository.findAll();
    }
    @ApiOperation(value = "Get Company by ID"  )
    @GetMapping("{companyId}")
    private Company getCompanyById(@PathVariable Long companyId){
        return companyRepository.findById(companyId).orElseThrow(()->
                new NoSuchElementException("Can not find Company with ID : " + companyId));
    }

    @PostMapping
    @ApiOperation(value = "Add New Company" )
    public Company addNewCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }


}
