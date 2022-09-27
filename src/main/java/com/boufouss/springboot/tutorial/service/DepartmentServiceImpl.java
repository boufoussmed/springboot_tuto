package com.boufouss.springboot.tutorial.service;

import com.boufouss.springboot.tutorial.entity.Department;
import com.boufouss.springboot.tutorial.error.DepartmentNotFoundException;
import com.boufouss.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentsList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> dept = departmentRepository.findById(departmentId);

        if(!dept.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }

        return dept.get();
    }

    @Override
    public void deleteDepById(Long depId) {
        departmentRepository.deleteById(depId);
    }

    @Override
    public Department updateDepById(Long id, Department department) {

        Department depDb = departmentRepository.findById(id).get();

        if (Objects.nonNull(department) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        return this.departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String depName) {
        return this.departmentRepository.findByDepartmentNameIgnoreCase(depName);
    }
}
