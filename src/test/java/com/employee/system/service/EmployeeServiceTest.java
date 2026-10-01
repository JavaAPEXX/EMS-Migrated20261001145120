```java
package com.employee.system.service;

import com.employee.system.dto.EmployeeDTO;
import com.employee.system.entity.Employee;
import com.employee.system.repository.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    // -------------------------------------------------------------------------
    // Helper methods to create sample objects
    // -------------------------------------------------------------------------
    private EmployeeDTO sampleDto() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(1L);
        dto.setEmployeeId("E123");
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setEmail("john.doe@example.com");
        dto.setPhoneNumber("1234567890");
        dto.setDepartment("IT");
        dto.setDesignation("Developer");
        dto.setDateOfJoining(LocalDate.of(2020, 1, 15));
        dto.setStatus("ACTIVE");
        dto.setAddress("123 Main St");
        dto.setDateOfBirth(LocalDate.of(1990, 5,