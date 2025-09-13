package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum KategoriMakanan {

    MAKANAN_POKOK("Makanan Pokok"),
    MAKANAN_RINGAN("Makanan Ringan"),
    MAKANAN_PENUTUP("Makanan Penutup"),
    LAUK_SAMPINGAN("Lauk Sampingan"),
    VEGETARIAN("Vegetarian"),
    BREAK_FAST_MENU("Break Fast Menu"),
    MENU_SPESIAL("Menu Spesial");

    private final String label;

    KategoriMakanan(String label) {
        this.label = label;
    }

}

