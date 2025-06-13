package com.spwbt.staff.staff;

import com.spwbt.staff.staff.dto.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> employees();

    Employee save(EmployeeRequest request);

    Employee findById(Long employeeId);

    void delete(Long employeeId);
}
