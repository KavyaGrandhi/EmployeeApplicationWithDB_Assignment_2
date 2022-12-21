package com.organization.EmployeeApplicationWithDB.Repository;

import com.organization.EmployeeApplicationWithDB.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
