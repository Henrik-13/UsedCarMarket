package io.github.henrik13.usedcarmarket.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarFilter {
    private String make;
    private String model;
    private Long minPrice;
    private Long maxPrice;
}
