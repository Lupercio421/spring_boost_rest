package com.example.payroll_maven;

import org.springframework.data.jpa.repository.JpaRepository;

//     specifying the domain type as Employee and the id type as Long.
interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

