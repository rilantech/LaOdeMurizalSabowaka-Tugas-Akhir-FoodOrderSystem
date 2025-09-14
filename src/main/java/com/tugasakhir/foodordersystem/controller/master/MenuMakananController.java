package com.tugasakhir.foodordersystem.controller.master;

import com.tugasakhir.foodordersystem.model.filter.MenuMakananFilterRecord;
import com.tugasakhir.foodordersystem.model.filter.UserFilterRecord;
import com.tugasakhir.foodordersystem.model.request.MenuMakananRequestRecord;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.managementuser.UserService;
import com.tugasakhir.foodordersystem.service.master.MenuMakananService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu-makanan")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Menu Makanan Api")
public class MenuMakananController {

        private final MenuMakananService menuMakananService;
        @PostMapping("save")
        @PreAuthorize("hasRole('ADMIN')")
        public BaseResponse<?> save(@RequestBody MenuMakananRequestRecord request) {
            menuMakananService.add(request);
            return BaseResponse.ok("Data berhasil disimpan", null);
        }

        @PutMapping("edit")
        @PreAuthorize("hasRole('ADMIN')")
        public BaseResponse<?> edit(@RequestBody MenuMakananRequestRecord request) {
            menuMakananService.edit(request);
            return BaseResponse.ok("Data berhasil diubah", null);
        }

        @PostMapping("find-all")
        @PreAuthorize("hasAnyRole('ADMIN', 'PELANGGAN')")
        public BaseResponse<?> findAll(@PageableDefault(direction = Sort.Direction.DESC, sort = "modifiedDate") Pageable pageable,
                                       @RequestBody MenuMakananFilterRecord filterRequest) {
            return BaseResponse.ok(null, menuMakananService.findAll(filterRequest, pageable));
        }

        @GetMapping("find-by-id/{id}")
        @PreAuthorize("hasAnyRole('ADMIN', 'PELANGGAN')")
        public BaseResponse<?> findById(@PathVariable String id) {
            return BaseResponse.ok(null, menuMakananService.findById(id));
        }

        @DeleteMapping("delete")
        @PreAuthorize("hasRole('ADMIN')")
        public BaseResponse<?> save(@RequestParam String id_menuMakanan) {
            menuMakananService.delete(id_menuMakanan);
            return BaseResponse.ok("Data berhasil dihapus", null);
        }
    }


