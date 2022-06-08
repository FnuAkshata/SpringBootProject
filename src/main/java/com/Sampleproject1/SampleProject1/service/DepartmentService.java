package com.Sampleproject1.SampleProject1.service;

import com.Sampleproject1.SampleProject1.entity.Department;
import com.Sampleproject1.SampleProject1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long deptId);

    Department updateDepartment(Long deptId, Department department);

    Department fetchDeptByName(String deptName);


}
