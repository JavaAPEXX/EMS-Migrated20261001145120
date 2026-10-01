```java
package com.employee.system.service;

import com.employee.system.dto.RatingScaleDTO;
import com.employee.system.entity.RatingScale;
import com.employee.system.repository.RatingScaleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RatingScaleServiceTest {

    @Mock
    private RatingScaleRepository ratingScaleRepository;

    @InjectMocks
    private RatingScaleService ratingScaleService;

    /* -------------------------------------------------
       getRatingScaleById
       ------------------------------------------------- */

    @Test
    @DisplayName("Given existing id when getRatingScaleById then return DTO")
    void givenExistingId_whenGetRatingScaleById_thenReturnDto() {
        // Arrange
        Long id = 1L;
        RatingScale entity = new RatingScale();
        entity.setId(id);
        entity.setRatingValue(5);
        entity.setRatingLabel("Excellent");
        entity.setRatingDescription("Top performance");
        entity.setColorCode("#00FF00");
        entity.setMinimumScore(90);
        entity.setMaximumScore(100);
        entity.setIsActive(true);
        when(ratingScaleRepository.findById(id)).thenReturn(Optional.of(entity));

        // Act
        RatingScaleDTO result = ratingScaleService.getRatingScaleById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(entity.getRatingValue(), result.getRatingValue());
        assertEquals(entity.getRatingLabel(), result.getRatingLabel());
        assertEquals(entity.getRatingDescription(), result.getRatingDescription());
        assertEquals(entity.getColorCode(), result.getColorCode());
        assertEquals(entity.getMinimumScore(), result.getMinimumScore());
        assertEquals(entity.getMaximumScore(), result.getMaximumScore());
        assertEquals(entity.getIsActive(), result.getIsActive());
        verify(ratingScale