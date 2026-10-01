```java
package com.employee.system.service;

import com.employee.system.dto.SelfAssessmentDTO;
import com.employee.system.entity.Employee;
import com.employee.system.entity.SelfAssessment;
import com.employee.system.repository.EmployeeRepository;
import com.employee.system.repository.SelfAssessmentRepository;
import org.junit.jupiter.api.DisplayName;
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
class SelfAssessmentServiceTest {

    @Mock
    private SelfAssessmentRepository assessmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private SelfAssessmentService selfAssessmentService;

    // -------------------------------------------------------------------------
    // createAssessment
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Create assessment with all fields set")
    void givenValidDto_whenCreateAssessment_thenReturnSavedDto() {
        // Arrange
        Long employeeId = 1L;
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setFirstName("John");
        employee.setLastName("Doe");

        SelfAssessmentDTO inputDto = new SelfAssessmentDTO();
        inputDto.setEmployeeId(employeeId);
        inputDto.setAssessmentPeriod("2023-Q1");
        inputDto.setAssessmentDate(LocalDate.of(2023, 3,