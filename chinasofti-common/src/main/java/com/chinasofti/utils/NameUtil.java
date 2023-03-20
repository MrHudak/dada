package com.chinasofti.utils;

import java.util.regex.Pattern;

public class NameUtil {

    /**
     * Java文件操作 获取文件扩展名
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * Java文件操作 获取不带扩展名的文件名
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    public static Integer getUploadFlieType(String extName) {

        Integer fileType = null;//(gif|jpg|jpeg|png...)
        String imgReg = "(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP|svg|SVG)$";
        boolean imgBool = Pattern.compile(imgReg).matcher(extName).find();
        if (imgBool) {
            fileType = 1;
        }
        String videoReg = "(mp4|MP4|wmv|WMV|flv|FLV|avi|AVI)$";
        boolean videoBool = Pattern.compile(videoReg).matcher(extName).find();
        if (videoBool) {
            fileType = 2;
        }

        String docReg = "(txt|TXT|doc|DOC|xls|XLS|ppt|PPT|docx|DOCX|xlsx|XLSX|pptx|PPTX)$";
        boolean docBool = Pattern.compile(docReg).matcher(extName).find();
        if (docBool) {
            fileType = 3;
        }
        //其他文件类型
        if (fileType == null) {
            fileType = 4;
        }
        return fileType;
    }
}
