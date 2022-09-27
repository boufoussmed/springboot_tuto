package com.boufouss.springboot.tutorial.service;


import com.boufouss.springboot.tutorial.entity.Department;
import com.boufouss.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentsList();

    public Department fetchDepById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepById(Long depId);

    public Department updateDepById(Long id, Department department);

    public Department fetchDepartmentByName(String depName);

}
