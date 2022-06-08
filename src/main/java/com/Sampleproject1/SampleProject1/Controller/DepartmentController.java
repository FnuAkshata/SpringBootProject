package com.Sampleproject1.SampleProject1.Controller;

import com.Sampleproject1.SampleProject1.entity.Department;
import com.Sampleproject1.SampleProject1.error.DepartmentNotFoundException;
import com.Sampleproject1.SampleProject1.service.DepartmentService;
import com.Sampleproject1.SampleProject1.service.DepartmentServiceImpl;
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

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DeparmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(deptId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deptId){
        departmentService.deleteDepartmentById(deptId);
        return "Deletion seccussfull";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long deptId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(deptId,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String deptName){
        return departmentService.fetchDeptByName(deptName);
    }

}
