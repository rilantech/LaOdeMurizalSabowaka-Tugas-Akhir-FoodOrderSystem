package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusMasak {

    SEDANG_DIMASAK("Sedang Dimasak"),
    SELESAI("Selesai");

    private final String label;

    StatusMasak(String label) {
        this.label = label;
    }

}

