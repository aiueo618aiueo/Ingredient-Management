package com.example.Ingredient_Management.dto;

import com.example.Ingredient_Management.constant.ValidationConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDto {
    @NotEmpty
    @Pattern(regexp = ValidationConstants.ONE_TO_FIFTEEN)
    private String name;

    @NotEmpty
    @Pattern(regexp = ValidationConstants.NUBMER_SIX)
    private String password;
}
