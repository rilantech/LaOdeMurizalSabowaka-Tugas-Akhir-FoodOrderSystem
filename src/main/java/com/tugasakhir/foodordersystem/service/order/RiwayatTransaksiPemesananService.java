package com.tugasakhir.foodordersystem.service.order;

import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.filter.PesananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.RiwayatTransaksiPemesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RiwayatTransaksiPemesananService {

    void add(PesananRequestRecord request);

    void edit(PesananRequestRecord request);

    Page<SimpleMap> findAll(RiwayatTransaksiPemesananFilterRecord filterRequest, Pageable pageable);

    SimpleMap findById(String id);

    void delete(String idTransaksi);

}