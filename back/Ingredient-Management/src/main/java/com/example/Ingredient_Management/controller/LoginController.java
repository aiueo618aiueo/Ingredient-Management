package com.example.Ingredient_Management.controller;


import com.example.Ingredient_Management.exception.BusinessException;
import com.example.Ingredient_Management.constant.ApiConstants;
import com.example.Ingredient_Management.constant.ApiResponses;
import com.example.Ingredient_Management.dto.LoginDto;
import com.example.Ingredient_Management.service.ValidationCheck;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/Ingredient-Management/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody LoginDto loginForm){
        Map<String, Object> response = new LinkedHashMap<>();

        ValidationCheck.validate(loginForm);

        // ログインチェック
        if (!ApiConstants.NAME.equals(loginForm.getName())
            || !ApiConstants.PASSWORD.equals(loginForm.getPassword())) {

            System.out.println(ApiConstants.LOGIN_ERROR);
            throw new BusinessException(ApiConstants.LOGIN_ERROR);
        }


        response.put(ApiConstants.RESULT_CODE, ApiResponses.SUCCESS.getCode());
        response.put(ApiConstants.RESULT_MESSAGE, ApiResponses.SUCCESS.getMessage());

        return ResponseEntity.ok(response);
    }
}
