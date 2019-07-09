package com.springbootchannel.humanresources.repository;

import com.springbootchannel.humanresources.domain.Company;
import com.springbootchannel.humanresources.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
