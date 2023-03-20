package com.chinasofti.dao;

import com.chinasofti.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface ProductEsDao extends ElasticsearchRepository<Product,String> {
 // 按关键词分页查询
         public Page<Product> findByTitle(String title, Pageable pageable);
 }