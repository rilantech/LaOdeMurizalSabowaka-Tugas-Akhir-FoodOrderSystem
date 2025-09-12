package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusPesanan {
    SELESAI("Selesai"),
    BELUM_SELESAI("Belum Selesai");

    private final String label;

    StatusPesanan(String label) {
        this.label = label;
    }

}

