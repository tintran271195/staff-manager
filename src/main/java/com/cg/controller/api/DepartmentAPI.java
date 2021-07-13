package com.cg.controller.api;

import com.cg.model.Department;
import com.cg.service.department.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentAPI {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Department>> allDepartment() {
        Iterable<Department> departments = departmentService.findAll();
        if (((List) departments).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id) {
        Optional<Department> department = departmentService.findById(id);
        if (!department.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentService.remove(id);
        return new ResponseEntity<>(department.get(), HttpStatus.OK);
    }
}
