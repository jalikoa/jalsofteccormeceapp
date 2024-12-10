package com.jalsoft.android.eccormece;

public class FileModel {
    String fileName,fileDescription,dateFilePosted;

    public FileModel(String fileName, String fileDescription, String dateFilePosted) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.dateFilePosted = dateFilePosted;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getDateFilePosted() {
        return dateFilePosted;
    }

    public void setDateFilePosted(String dateFilePosted) {
        this.dateFilePosted = dateFilePosted;
    }
}
