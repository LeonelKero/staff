package com.spwbt.staff.staff;

import com.spwbt.staff.staff.dto.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/employees"})
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> allEmployees() {
        return new ResponseEntity<>(this.service.employees(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> register(final @RequestBody EmployeeRequest request) {
        return new ResponseEntity<>(this.service.save(request), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Employee> findById(final @PathVariable Long id) {
        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Void> delete(final @PathVariable Long id) {
        this.service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
