package com.chinasofti.service.impl;

import com.chinasofti.domain.Content;
import com.chinasofti.mapper.ContentMapper;
import com.chinasofti.service.ContentService;
import com.chinasofti.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public class ContentServiceImpl implements ContentService {

         @Autowired
 private ContentMapper contentMapper;


         @Override
 public List<Content> selectContentList(Content content) {
         return this.contentMapper.selectContentList(content);
         }

         @Override
 public void insertContent(Content content) {
         this.contentMapper.insertContent(content);
         }

         @Override
 public void deleteContentByIds(String ids) {
         this.contentMapper.deleteContentByIds(Convert.toStrArray(ids));
         }
 }
