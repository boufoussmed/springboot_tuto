package com.boufouss.springboot.tutorial.repository;

import com.boufouss.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /*
    for more info abt creating other special query complex methods
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
     */
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
