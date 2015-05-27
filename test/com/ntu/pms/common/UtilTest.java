package com.ntu.pms.common;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.service.AttachmentService;
import com.ntu.pms.utils.StringUtils;

public class UtilTest {

    @Autowired
    private AttachmentService attachmentService;

    @Test
    public void StringUtilsTest() {
        String s = StringUtils.getRandomUrlString();
        System.out.println(s);
    }

    @Test
    public void StringTest() {
        String url = "http://aaa/bbb/ccc";
        String a = url.substring(url.lastIndexOf("/") + 1, url.length() - 1);
        System.out.println(a);
    }

    @Test
    public void addFolderTest() {
        File file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + 2 + "\\" + "test");
        file.mkdirs();
    }

    @Test
    public void addAttachment() throws IOException {
        File file = new File("D:\\毕业设计\\论文\\往年毕业设计论文参考.pdf");
        String fileFolder = OtherConstants.BASE_PROJECT_FOLDER + "\\" + 2 + "\\" + "图片";
        File targetFile = new File(fileFolder, file.getName());
        // FileUtils.copyFile(file, targetFile);
        targetFile.createNewFile();
    }
}
