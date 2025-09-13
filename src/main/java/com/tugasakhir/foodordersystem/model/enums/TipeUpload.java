package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum TipeUpload {
    PROFIL("Profil"),
    MAKANAN("Makanan");

    private final String label;

    TipeUpload(String label) {
        this.label = label;
    }

}
