package io.github.henrik13.usedcarmarket.dto.outdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarOutDto {
    private Integer id;
    private String make;
    private String model;
    private String description;
    private Long price;
}
