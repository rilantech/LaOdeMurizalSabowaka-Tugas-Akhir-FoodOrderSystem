package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum StatusMakanan {

    LAKU("LAKU"),
    BELUM_LAKU("BELUM_LAKU");

    private final String label;

    StatusMakanan(String label) {
        this.label = label;
    }

}

