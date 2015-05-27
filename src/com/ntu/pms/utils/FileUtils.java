package com.ntu.pms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

    public static void deleteAllFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File filee : files) {
                deleteAllFile(filee);
            }
        } else {
            file.delete();
        }
    }

    public static void copyFile(MultipartFile multipartFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        File sourceFile = new File("");
        multipartFile.transferTo(sourceFile);
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
}
