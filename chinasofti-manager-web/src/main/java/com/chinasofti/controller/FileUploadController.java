package com.chinasofti.controller;

import com.chinasofti.utils.NameUtil;
import com.chinasofti.utils.StringUtils;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.lettuce.core.dynamic.annotation.Value;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/restful/file")
 @Controller
 public class FileUploadController {

         //获取属性的值


         @Autowired
 protected FastFileStorageClient fastFileStorageClient;

         @RequestMapping(value = "/upload",method = RequestMethod.POST)
 @ResponseBody
 public Map<String,Object> upload(MultipartFile file,
                                  HttpServletResponse response,
                                  HttpServletRequest request){

         Map<String,Object> map = new HashMap<>();

         String visitUrl = null;

         //获取文件的名称
         String fileName = file.getOriginalFilename();

         //获取文件的扩展名
         String suffixName = FilenameUtils.getExtension(fileName);
         long fileSize = file.getSize();
         //获取上传文件的类型
         Integer fileType = NameUtil.getUploadFlieType(suffixName);

         try{
             //判断上传文件的类型
             if (fileType==1){
                 //获取上传文件的扩展名
                 String fileTypeName =
                        StringUtils.substringAfterLast(file.getOriginalFilename(), ".");


                 //上传FastDFS
                 StorePath path = fastFileStorageClient.uploadFile(file.getInputStream(),
                        fileSize, suffixName, null);
                 String url = path.getFullPath();
                 String group = path.getGroup();
                 String pathIn = path.getPath();

                 visitUrl="http://116.62.133.135/"+url;
                 System.out.println(visitUrl);
                 map.put("state","SUCCESS");
                 map.put("url",visitUrl);
                 map.put("size",file.getSize());
                 map.put("original",fileTypeName);
                 map.put("type",file.getContentType());
                 }

             }catch (Exception e){
             e.printStackTrace();
             }


         return map;
         }

         }