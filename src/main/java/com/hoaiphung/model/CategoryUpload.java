package com.hoaiphung.model;

import org.springframework.web.multipart.MultipartFile;

public class CategoryUpload extends Category {
    private MultipartFile multipartFileCate;

    public MultipartFile getMultipartFileCate() {
        return multipartFileCate;
    }

    public void setMultipartFileCate(MultipartFile multipartFileCate) {
        this.multipartFileCate = multipartFileCate;
    }
}
