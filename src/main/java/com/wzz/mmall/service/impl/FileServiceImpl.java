package com.wzz.mmall.service.impl;

import com.google.common.collect.Lists;
import com.wzz.mmall.service.IFileService;
import com.wzz.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        // 扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 起一个新名字，防止不同用户传相同文件名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件，上传的文件名：{}, 上传的路径：{}, 新文件名：{}", fileName, path, uploadFileName);

        // 建立文件夹
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            // 上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            // 删除tomcat目录的upload文件夹下的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常 ", e);
            return null;
        }

        return targetFile.getName();
    }

//    public static void main(String[] args) {
//        String fileName = "abc.gif";
//        System.out.println(fileName.substring(fileName.lastIndexOf(".")));
//    }
}
