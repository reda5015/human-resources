package com.springbootchannel.humanresources.repository;

import com.springbootchannel.humanresources.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company , Long> {
}
