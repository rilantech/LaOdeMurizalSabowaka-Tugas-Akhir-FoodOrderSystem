package com.tugasakhir.foodordersystem.controller.app;

import com.tugasakhir.foodordersystem.model.enums.TipeUpload;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import com.tugasakhir.foodordersystem.service.app.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("foto-profil")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Foto Profil User Api")
public class FotoProfilController {

    private final FileService fileService;

    @PostMapping(path = "upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public BaseResponse<?> uploadFile(@RequestPart MultipartFile file,
                                      @RequestParam TipeUpload tipeUpload) {
        return fileService.upload(file, tipeUpload);
    }

    @GetMapping("view")
    public void viewFile(@RequestParam String pathFile, HttpServletResponse response) throws IOException {
        Resource resource = fileService.loadFileAsResource(pathFile);
        IOUtils.copy(resource.getInputStream(), response.getOutputStream());
    }

}
