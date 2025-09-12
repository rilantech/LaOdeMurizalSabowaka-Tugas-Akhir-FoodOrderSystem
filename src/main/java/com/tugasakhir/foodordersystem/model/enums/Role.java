package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum Role {

    ADMIN("Admin"),
    OWNER("Owner"),
    KASIR("Kasir"),
    KOKI("Koki"),
    PELANGGAN("Pelanggan");

    private final String label;

    Role(String label) {
        this.label = label;
    }

}
