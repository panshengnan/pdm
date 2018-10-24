package com.cgwx.data.dto;

import java.util.List;

public class DirectoryInfo {

    private String directoryName;

    private List<String> fileListInDirectory;

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public List<String> getFileListInDirectory() {
        return fileListInDirectory;
    }

    public void setFileListInDirectory(List<String> fileListInDirectory) {
        this.fileListInDirectory = fileListInDirectory;
    }
}
