package com.boufouss.springboot.tutorial.controller;

import com.boufouss.springboot.tutorial.entity.Department;
import com.boufouss.springboot.tutorial.error.DepartmentNotFoundException;
import com.boufouss.springboot.tutorial.service.DepartmentService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){

        LOGGER.info("Saving a department in DepartmentController saveDepartment" );
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentsList(){
        LOGGER.info("Fetch department(s) in DepartmentController fetchDepartmentList" );
        return departmentService.fetchDepartmentsList();
    }

    @SneakyThrows
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId)  {
        return departmentService.fetchDepById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long depId){
        departmentService.deleteDepById(depId);
        return "department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,@RequestBody Department department){
        return departmentService.updateDepById(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String depName){
        return this.departmentService.fetchDepartmentByName(depName);
    }
}
