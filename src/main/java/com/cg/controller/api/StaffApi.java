package com.cg.controller.api;

import com.cg.model.Staff;
import com.cg.service.department.IDepartmentService;
import com.cg.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffApi {

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
            return new ResponseEntity<>(staff, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        if()
    }
}
