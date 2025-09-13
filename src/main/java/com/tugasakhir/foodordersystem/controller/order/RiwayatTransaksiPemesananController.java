package com.tugasakhir.foodordersystem.controller.order;

import com.tugasakhir.foodordersystem.model.filter.PesananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.RiwayatTransaksiPemesananFilterRecord;
import com.tugasakhir.foodordersystem.model.request.PesananRequestRecord;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.order.PesananService;
import com.tugasakhir.foodordersystem.service.order.RiwayatTransaksiPemesananService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("riwayat-transaksi-pemesanan")
@RequiredArgsConstructor
@Slf4j
public class RiwayatTransaksiPemesananController {

        private final RiwayatTransaksiPemesananService riwayatTransaksiPemesananService;
        @PostMapping("save")
        public BaseResponse<?> save(@RequestBody PesananRequestRecord request) {
            riwayatTransaksiPemesananService.add(request);
            return BaseResponse.ok("Data berhasil disimpan", null);
        }

        @PutMapping("ubah-status-pesanan")
        public BaseResponse<?> edit(@RequestBody PesananRequestRecord request) {
            riwayatTransaksiPemesananService.edit(request);
            return BaseResponse.ok("Data berhasil diubah", null);
        }

        @PostMapping("find-all")
        public BaseResponse<?> findAll(@PageableDefault(direction = Sort.Direction.DESC, sort = "modifiedDate") Pageable pageable,
                                       @RequestBody RiwayatTransaksiPemesananFilterRecord filterRequest) {
            return BaseResponse.ok(null, riwayatTransaksiPemesananService.findAll(filterRequest, pageable));
        }
//
        @GetMapping("find-by-id/{id}")
        public BaseResponse<?> findById(@PathVariable String id) {
            return BaseResponse.ok(null, riwayatTransaksiPemesananService.findById(id));
        }
//
        @DeleteMapping("delete")
        public BaseResponse<?> save(@RequestParam String idTransaksi) {
            riwayatTransaksiPemesananService.delete(idTransaksi);
            return BaseResponse.ok("Data riwayat transaksi pemesanan berhasil dihapus", null);
        }
    }


