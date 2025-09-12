package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusUser {
    AKTIF("AKTIF"),
    TIDAK_AKTIF("TIDAK_AKTIF");

    private final String label;

    StatusUser(String label) {
        this.label = label;
    }

}

