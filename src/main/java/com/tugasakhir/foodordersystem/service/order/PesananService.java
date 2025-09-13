package com.tugasakhir.foodordersystem.service.order;

import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.PesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UbahStatusPesananRequestRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PesananService {

    void add(PesananRequestRecord request);

    void edit(PesananRequestRecord request);

    Page<SimpleMap> findAll(PesananFilterRecord filterRequest, Pageable pageable);

    SimpleMap findById(String id);

    void delete(String idPesanan);

}