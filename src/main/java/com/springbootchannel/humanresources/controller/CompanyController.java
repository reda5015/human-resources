package com.springbootchannel.humanresources.controller;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    @RequestMapping({"", "list"})
    public String getCompanyList(Model model) {
        model.addAttribute("companiesList", companyRepository.findAll());
        return "companies/List";
    }

    @RequestMapping("new")
    public String getNewCompany(Model model) {
        model.addAttribute("company", new Company());

        return "companies/new-update";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postCompany(Company company, RedirectAttributes redirectAttributes) {
        companyRepository.save(company);
        redirectAttributes.addFlashAttribute("savedSuccessfully", true);
        return "redirect:/companies/";
    }

    @RequestMapping("{companyId}")
    public String getCompanyDetails(Model model, @PathVariable Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            model.addAttribute("company", company.get());
        }
        else
        {
            model.addAttribute("noSuchElement", true);
        }

        return "companies/new-update";
    }
}
