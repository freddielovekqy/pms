package com.ntu.pms.dto;

import java.io.File;

public class UploadAttachmentDTO {

    private String baseFilePath;
    private File file;

    public String getBaseFilePath() {
        return baseFilePath;
    }

    public void setBaseFilePath(String baseFilePath) {
        this.baseFilePath = baseFilePath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
