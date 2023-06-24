package com.agus.project.file;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        File dir = new File(uploadDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = uploadDir + fileName;
        File file = new File(filePath);

        FileCopyUtils.copy(multipartFile.getBytes(), file);
    }
}

