package com.boufouss.springboot.tutorial.repository;

import com.boufouss.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentAddress("Agadir")
                .departmentName("Eng")
                .departmentCode("ENG-09")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void testIfDataAvailable() {
        Department department = departmentRepository.findById(1L).get();

        System.out.println(department);
        assertEquals(department.getDepartmentName(), "Eng");
    }


}