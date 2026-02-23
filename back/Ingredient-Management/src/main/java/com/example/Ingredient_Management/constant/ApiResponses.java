package com.example.Ingredient_Management.constant;

public enum ApiResponses {
    SUCCESS("200", "success"),
    ERROR("400", "error");

    private final String code;
    private final String message;

    ApiResponses(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
