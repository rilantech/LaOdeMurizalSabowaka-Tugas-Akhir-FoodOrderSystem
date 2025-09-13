package com.tugasakhir.foodordersystem.service.master;

import com.tugasakhir.foodordersystem.model.app.SimpleMap;
import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.UserFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuMakananService {

    void add(MenuMakananRequestRecord request);

    void edit(MenuMakananRequestRecord request);

    Page<SimpleMap> findAll(MenuMakananFilterRecord filterRequest, Pageable pageable);

    SimpleMap findById(String id);

    void delete(String id);

}