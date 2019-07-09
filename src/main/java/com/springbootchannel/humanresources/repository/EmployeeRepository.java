package com.springbootchannel.humanresources.repository;

import com.springbootchannel.humanresources.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
