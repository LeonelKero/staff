package com.spwbt.staff.staff;

import com.spwbt.staff.staff.dto.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> employees() {
        return this.repository.findAll();
    }

    @Override
    public Employee save(final EmployeeRequest request) {
        final var employee = Employee.builder()
                .name(request.name())
                .email(request.email())
                .build();
        return this.repository.save(employee);
    }

    @Override
    public Employee findById(final Long employeeId) {
        return this.repository.findById(employeeId).orElse(null);
    }

    @Override
    public void delete(final Long employeeId) {
        this.repository.findById(employeeId).ifPresent(repository::delete);
    }
}
