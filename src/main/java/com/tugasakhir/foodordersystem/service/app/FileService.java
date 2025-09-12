package com.tugasakhir.foodordersystem.service.app;

import com.tugasakhir.foodordersystem.model.enums.TipeUpload;
import com.tugasakhir.foodordersystem.model.response.BaseResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    BaseResponse<?> upload(MultipartFile files, TipeUpload tipeUpload);

    Resource loadFileAsResource(String pathFile);

}