package com.Sampleproject1.SampleProject1.service;

import com.Sampleproject1.SampleProject1.entity.Department;
import com.Sampleproject1.SampleProject1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .deptName("ISE")
                        .deptAddress("San Jose")
                        .deptCode("ISE01")
                        .deptId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDeptNameIgnoreCase("ISE"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data bease on validate department name")
    public void whenValidateDepartmentName_thenDepartmentShouldFound(){
        String deptName = "ISE";
        Department found = departmentService.fetchDeptByName(deptName);

        assertEquals(deptName, found.getDeptName());

    }
}