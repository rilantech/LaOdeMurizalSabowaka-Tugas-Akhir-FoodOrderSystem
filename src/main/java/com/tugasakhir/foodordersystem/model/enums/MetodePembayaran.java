package com.tugasakhir.foodordersystem.model.enums;

import lombok.Getter;

@Getter
public enum MetodePembayaran {

    TRANSFER_BANK("Transfer Bank"),
    E_WALLET("E-Wallet"),
    QRISH("QRISH"),
    COD("COD");

    private final String label;

    MetodePembayaran(String label) {
        this.label = label;
    }

}

