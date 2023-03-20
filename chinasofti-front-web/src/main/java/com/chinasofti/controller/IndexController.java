package com.chinasofti.controller;

import com.chinasofti.domain.Content;
import com.chinasofti.service.ContentService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

//    /**
//     * 显示首页
//     */
//    @RequestMapping(value = "index.html",method = RequestMethod.GET)
//    public ModelAndView toPage(){
//        ModelAndView mv  = new ModelAndView("index");
//        return mv;
//    }

    @Autowired
    private ContentService contentService;

    /**
     * 显示首页
     */
    @RequestMapping(value = "index.html",method = RequestMethod.GET)
    public ModelAndView toPage(){
        ModelAndView mv  = new ModelAndView("index");
        //读取大广告位信息
        Content content = new Content();
        content.setCategoryid(21L);
        ResponseEntity<List<Content>> responseEntity = contentService.selectContentListByCategoryId(content.getCategoryid());
//        List<Content> listBigAD =  this.contentService.selectContentList(content);
        List<Content> listBigAD = responseEntity.getBody();
        mv.addObject("bigADList",listBigAD);

        //读取小广告信息
        Content content2 = new Content();
        content2.setCategoryid(24L);
        responseEntity = contentService.selectContentListByCategoryId(content.getCategoryid());
//        List<Content> listSmallAD =  this.contentService.selectContentList(content2);
        List<Content> listSmallAD = responseEntity.getBody();
        mv.addObject("smallADList",listSmallAD);

        return mv;
    }
}