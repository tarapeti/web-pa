package com.codecool.web.dto;

import com.codecool.web.model.Signature;

import java.util.List;

public class SignaturesDto {
    private List<List<String>> allNames;

    public SignaturesDto(List<List<String>> allNames) {
        this.allNames = allNames;
    }

    public List<List<String>> getAllNames() {
        return allNames;
    }
}
