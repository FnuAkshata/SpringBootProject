package com.Sampleproject1.SampleProject1.service;

import com.Sampleproject1.SampleProject1.entity.Department;
import com.Sampleproject1.SampleProject1.error.DepartmentNotFoundException;
import com.Sampleproject1.SampleProject1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException {
       Optional<Department> department = departmentRepository.findById(deptId);

       if(!department.isPresent()){
           throw new DepartmentNotFoundException("Department not available!");
       }
       return department.get();
    }

    @Override
    public void deleteDepartmentById(Long deptId) {
         departmentRepository.deleteById(deptId);
    }

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department depDB = departmentRepository.findById(deptId).get();

        if (Objects.nonNull(department.getDeptName()) &&
                !"".equalsIgnoreCase(department.getDeptName())) {
            depDB.setDeptName((department.getDeptName()));
        }

        if (Objects.nonNull(department.getDeptCode()) &&
                !"".equalsIgnoreCase(department.getDeptCode())) {
            depDB.setDeptCode((department.getDeptCode()));
        }

        if (Objects.nonNull(department.getDeptAddress()) &&
                !"".equalsIgnoreCase(department.getDeptAddress())) {
            depDB.setDeptAddress((department.getDeptAddress()));
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDeptByName(String deptName) {
        return departmentRepository.findByDeptNameIgnoreCase(deptName);
    }

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
