package io.github.henrik13.usedcarmarket.dto.indto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInDto {
    @NotBlank
    @Size(max = 20)
    private String make;
    @NotBlank
    @Size(max = 20)
    private String model;
    @NotBlank
    @Size(max = 200)
    private String description;
    @Positive(message = "Price must be a positive number")
    @Max(value = 9999999999L, message = "Price must not exceed 9,999,999,999")
    private Long price;
}
