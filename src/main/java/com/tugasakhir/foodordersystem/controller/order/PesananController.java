package com.tugasakhir.foodordersystem.controller.order;

import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.PesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.model.request.UbahStatusPesananRequestRecord;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.master.MenuMakananService;
import com.tugasakhir.foodordersystem.service.order.PesananService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pesanan")
@RequiredArgsConstructor
@Slf4j
public class PesananController {

        private final PesananService pesananService;
        @PostMapping("save")
        public BaseResponse<?> save(@RequestBody PesananRequestRecord request) {
            pesananService.add(request);
            return BaseResponse.ok("Data berhasil disimpan", null);
        }

        @PutMapping("ubah-status-pesanan")
        public BaseResponse<?> edit(@RequestBody PesananRequestRecord request) {
            pesananService.edit(request);
            return BaseResponse.ok("Data berhasil diubah", null);
        }

        @PostMapping("find-all")
        public BaseResponse<?> findAll(@PageableDefault(direction = Sort.Direction.DESC, sort = "modifiedDate") Pageable pageable,
                                       @RequestBody PesananFilterRecord filterRequest) {
            return BaseResponse.ok(null, pesananService.findAll(filterRequest, pageable));
        }
//
        @GetMapping("find-by-id/{id}")
        public BaseResponse<?> findById(@PathVariable String id) {
            return BaseResponse.ok(null, pesananService.findById(id));
        }
//
        @DeleteMapping("delete")
        public BaseResponse<?> save(@RequestParam String idPesanan) {
            pesananService.delete(idPesanan);
            return BaseResponse.ok("Data pesanan berhasil dibatalkan", null);
        }
    }


