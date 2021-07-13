package com.cg.controller.api;

import com.cg.model.Department;
import com.cg.model.Staff;
import com.cg.service.department.IDepartmentService;
import com.cg.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffAPI {

    @Autowired
    private IStaffService staffService;

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Staff>> allStaff() {
        Iterable<Staff> staff = staffService.findAll();
        if (((List) staff).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Staff> getId(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        if (staff.isPresent()) {
            return new ResponseEntity<>(staff.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        if (staff.getId() != null) {
            return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
        }

        Optional<Department> department = departmentService.findById(staff.getDepartment().getId());

        if (department.isPresent()) {
            staff.setDepartment(department.get());
            return new ResponseEntity<>(staffService.save(staff), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Staff> deleteStaff(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.remove(id);
        return new ResponseEntity<>(staff.get(), HttpStatus.NO_CONTENT);
    }
}
