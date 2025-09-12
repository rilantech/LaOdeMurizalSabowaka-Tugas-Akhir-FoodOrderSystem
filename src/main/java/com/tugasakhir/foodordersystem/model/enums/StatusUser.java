package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusUser {
    AKTIF("Aktif"),
    TIDAK_AKTIF("Tidak Aktif");

    private final String label;

    StatusUser(String label) {
        this.label = label;
    }

}

