package com.wzz.mmall.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    /**
     * 上传文件到ftp服务器
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
