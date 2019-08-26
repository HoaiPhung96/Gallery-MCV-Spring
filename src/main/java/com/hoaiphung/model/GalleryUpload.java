package com.hoaiphung.model;

import org.springframework.web.multipart.MultipartFile;

public class GalleryUpload extends Gallery {
    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
