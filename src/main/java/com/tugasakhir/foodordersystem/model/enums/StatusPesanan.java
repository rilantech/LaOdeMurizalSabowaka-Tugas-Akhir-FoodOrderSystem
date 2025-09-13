package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusPesanan {
    DIPROSES("DiProses"),
    SUDAH_DIPROSES("SudahDiProses");

    private final String label;

    StatusPesanan(String label) {
        this.label = label;
    }

}

