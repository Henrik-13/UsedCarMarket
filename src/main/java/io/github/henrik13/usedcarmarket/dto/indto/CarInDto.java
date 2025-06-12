package io.github.henrik13.usedcarmarket.dto.indto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Positive
    @Digits(integer = 10, fraction = 0)
    private Integer price;
}
