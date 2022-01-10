package com.bingo.util;

import java.io.File;

import com.bingo.app.ContainerManage;

/**
 * 修改文件后缀
 *
 * @author h-bingo
 * @date 2022/01/05 18:37
 **/
public class OperFileSuffUtil {

    private static String FILE_SUFFIX_JAVA = ".java";

    private static String FILE_SUFFIX_ENCRP = ".encrp";

    public static void operMain(boolean isDecry) {
        File file = new File(ContainerManage.getTextField().getText());
        if (!file.exists()) {
            ContainerManage.appendTextArea(OperLog.operLog("文件或目录不存在！"));
            return;
        } else {
            eachFile(file, isDecry);
        }
    }

    private static void eachFile(File file, boolean isDecry) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                eachFile(file1, isDecry);
            }
        } else {
            upFileSuff(file, isDecry);
        }
    }

    private static void upFileSuff(File file, boolean isDecry) {
        String filePath = file.getAbsolutePath();
        String fileName = file.getName();
        String newFileName;
        if (isDecry) {
            if (fileName.endsWith(FILE_SUFFIX_ENCRP)) {
                String prefix = fileName.substring(0, fileName.indexOf("."));
                newFileName = prefix + FILE_SUFFIX_JAVA;
            } else {
                return;
            }
        } else {
            if (fileName.endsWith(FILE_SUFFIX_JAVA)) {
                String prefix = fileName.substring(0, fileName.indexOf("."));
                newFileName = prefix + FILE_SUFFIX_ENCRP;
            } else {
                return;
            }
        }
        filePath = filePath.replace(fileName, newFileName);
        writeFile(file, filePath);
    }

    private static void writeFile(File file, String filePath) {
        file.renameTo(new File(filePath));
        ContainerManage.appendTextArea(OperLog.operLog("新文件：" + filePath));
    }
}
