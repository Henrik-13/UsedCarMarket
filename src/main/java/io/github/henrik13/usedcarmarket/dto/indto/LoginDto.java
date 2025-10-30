package io.github.henrik13.usedcarmarket.dto.indto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 6, max = 25)
    private String password;
}
