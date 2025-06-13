package io.github.henrik13.usedcarmarket.dto.indto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarFilterDto {
    @Size(max = 50, message = "Make must not exceed 50 characters")
    private String make;
    @Size(max = 20, message = "Model must not exceed 20 characters")
    private String model;
    @Positive(message = "Min price must be a positive number")
    @Max(value = 99999999999L, message = "Min price must not exceed 9,999,999,999")
    private Long minPrice;
    @Positive(message = "Max price must be a positive number")
    @Max(value = 99999999999L, message = "Max price must not exceed 9,999,999,999")
    private Long maxPrice;
}
