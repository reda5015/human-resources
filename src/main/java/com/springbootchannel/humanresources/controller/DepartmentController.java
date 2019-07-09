package com.springbootchannel.humanresources.controller;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.domain.Department;
import com.springbootchannel.humanresources.repository.CompanyRepository;
import com.springbootchannel.humanresources.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;

    public DepartmentController(CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
        this.companyRepository = companyRepository;

        this.departmentRepository = departmentRepository;
    }

    @RequestMapping({"", "list"})
    public String getDepartmentList(Model model) {
        model.addAttribute("departmentList", departmentRepository.findAll());
        return "departments/List";
    }

    @RequestMapping("new")
    public String getNewDepartment(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("companiesList", companyRepository.findAll());
        return "departments/new-update";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postDepartment(Department department, Model model , RedirectAttributes redirectAttributes) {
        Optional<Company> company = companyRepository.findById(department.getCompany().getId());
        if (company.isPresent())
        {
            department.setCompany(company.get());
        }
        else
        {
            model.addAttribute("error", "Cannot find Company with ID: " + department.getCompany().getId());
            model.addAttribute("department", department);
            model.addAttribute("companiesList", companyRepository.findAll());
            return "departments/new-update";
        }
        departmentRepository.save(department);
        redirectAttributes.addFlashAttribute("savedSuccessfully", true);
        return "redirect:/departments//";
    }

    @RequestMapping("{departmentId}")
    public String getDepartmentDetails(Model model, @PathVariable Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            model.addAttribute("department", department.get());
            model.addAttribute("companiesList", companyRepository.findAll());
        }
        else
        {
            model.addAttribute("noSuchElement", true);
            model.addAttribute("companiesList", companyRepository.findAll());
        }

        return "departments/new-update";
    }

}
