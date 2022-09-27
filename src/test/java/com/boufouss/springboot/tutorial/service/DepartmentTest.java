package com.boufouss.springboot.tutorial.service;

import com.boufouss.springboot.tutorial.entity.Department;
import com.boufouss.springboot.tutorial.repository.DepartmentRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentTest {

    @Autowired
    private DepartmentService departmentService ;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentId(4L)
                .departmentName("IT-02")
                .departmentCode("IT-008")
                .departmentAddress("CAVE")
                .build();

        //whenDepNameIsOk_thenDepartShouldBeFound
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT-02")).thenReturn(department);

        //whenDepId_thenDepartShouldBeFound
        Mockito.when(departmentRepository.findById(4L)).thenReturn(Optional.ofNullable(department));

    }

    @Test
    @DisplayName("Test if a department exists using given name valid department name")
    //@Disabled //to skip a test
    public void whenDepNameIsOk_thenDepartShouldBeFound(){

        String departmentName = "IT-02";

        Department department = departmentService.fetchDepartmentByName(departmentName);

        System.out.println(department);

        assertEquals(departmentName, department.getDepartmentName());
    }
    @SneakyThrows
    @Test
    public void whenDepId_thenDepartShouldBeFound(){

        Long departmentId = 4L;

        Department department = departmentService.fetchDepById(departmentId);

        System.out.println(department);

        assertEquals(departmentId, department.getDepartmentId());
    }
}