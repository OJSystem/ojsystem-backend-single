package com.nami.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author nami
 */
public interface FileService {
    /**
     * 上传头像到OSS
     *
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
