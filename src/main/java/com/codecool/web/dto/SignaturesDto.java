package com.codecool.web.dto;

import com.codecool.web.model.Signature;

import java.util.List;

public class SignaturesDto {
    private final List<Signature> signatures;

    public SignaturesDto(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }
}
