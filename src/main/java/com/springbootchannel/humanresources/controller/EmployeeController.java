package com.springbootchannel.humanresources.controller;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.domain.Department;
import com.springbootchannel.humanresources.domain.Employee;
import com.springbootchannel.humanresources.repository.DepartmentRepository;
import com.springbootchannel.humanresources.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping({"", "list"})
    public String getEmployeeList(Model model) {
        model.addAttribute("employeeList", employeeRepository.findAll());
        return "employees/List";
    }

    @RequestMapping("new")
    public String getNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departmentsList", departmentRepository.findAll());
        return "employees/new-update";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String postEmployee(Employee employee, Model model, RedirectAttributes redirectAttributes) {
        Optional<Department> department = departmentRepository.findById(employee.getDepartment().getId());
        if (department.isPresent()) {
            employee.setDepartment(department.get());
        } else {
            model.addAttribute("error", "Cannot find Department with ID: " + employee.getDepartment().getId());
            model.addAttribute("employee", employee);
            model.addAttribute("departmentsList", departmentRepository.findAll());
            return "employees/new-update";
        }
        employeeRepository.save(employee);
        redirectAttributes.addFlashAttribute("savedSuccessfully", true);
        return "redirect:/employees/";
    }

    @RequestMapping("{employeeId}")
    public String getEmployeeDetails(Model model, @PathVariable Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("departmentsList", departmentRepository.findAll());
        } else {
            model.addAttribute("noSuchElement", true);
            model.addAttribute("departmentsList", departmentRepository.findAll());
        }

        return "employees/new-update";
    }

}
