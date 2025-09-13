package com.tugasakhir.foodordersystem.controller.managementuser;


import com.tugasakhir.foodordersystem.model.enums.TipeUpload;
import com.tugasakhir.foodordersystem.model.filter.UserFilterRecord;
import com.tugasakhir.foodordersystem.model.request.UserRequestRecord;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.managementuser.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
//@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("save")
    public BaseResponse<?> save(@RequestBody UserRequestRecord request) {
        userService.add(request);
        return BaseResponse.ok("Data berhasil disimpan", null);
    }

    @PutMapping("edit")
    public BaseResponse<?> edit(@RequestBody UserRequestRecord request) {
        userService.edit(request);
        return BaseResponse.ok("Data berhasil diubah", null);
    }

    @PostMapping("find-all")
    public BaseResponse<?> findAll(@PageableDefault(direction = Sort.Direction.DESC, sort = "modifiedDate") Pageable pageable,
                                   @RequestBody UserFilterRecord filterRequest) {
        return BaseResponse.ok(null, userService.findAll(filterRequest, pageable));
    }

    @GetMapping("find-by-id/{id}")
    public BaseResponse<?> findById(@PathVariable String id) {
        return BaseResponse.ok(null, userService.findById(id));
    }

    @DeleteMapping("delete")
    public BaseResponse<?> save(@RequestParam String idUser) {
        userService.delete(idUser);
        return BaseResponse.ok("Data berhasil dihapus", null);
    }
}
