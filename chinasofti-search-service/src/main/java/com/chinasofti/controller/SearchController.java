package com.chinasofti.controller;

import com.chinasofti.dao.ProductEsDao;
import com.chinasofti.domain.Product;
import com.chinasofti.domain.SolrResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
 public class SearchController {

         /* @Autowired
 private SearchService searchService;*/
         @Autowired
 private ProductEsDao productEsDao;

         @RequestMapping("search.html")
 public String searchProductList(Model model, String queryString, String cid, String
            price, Integer page, String sort){
         //productEsDao.searchSimilar();
         Pageable pageable = Pageable.ofSize(3).withPage(0);
         Page<Product> products = productEsDao.findByTitle(queryString,pageable);
         List<Product> productsl = products.getContent();
         SolrResult solrResult = new SolrResult();
         solrResult.setCurPage(page);
         solrResult.setPageCount(products.getTotalPages());
         solrResult.setProductList(productsl);
         solrResult.setRecordCount(products.getTotalElements());
         try{
             // String s =this.searchService.searchProductList(queryString,cid,price,page,sort);

             model.addAttribute("result",solrResult);
             model.addAttribute("queryString",queryString);
             model.addAttribute("cid",cid);
             model.addAttribute("price",price);
             model.addAttribute("sort",sort);
             model.addAttribute("page",page);

             }catch (Exception e){
             e.printStackTrace();
             }
         return "search";
         }
 }
