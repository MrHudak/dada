package com.chinasofti.service.impl;

import com.chinasofti.domain.Product;
import com.chinasofti.domain.Productdesc;
import com.chinasofti.mapper.ProductMapper;
import com.chinasofti.mapper.ProductdescMapper;
import com.chinasofti.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductdescMapper productdescMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void insertProduct(Product product, String editorValue) {
        this.productMapper.insertProduct(product);

        Productdesc productdesc = new Productdesc();
        productdesc.setId(product.getId());
        productdesc.setProductdesc(editorValue);
        this.productdescMapper.insertProductdesc(productdesc);
    }

    @Override
    public List<Product> selectProductList(Product product) {return this.productMapper.selectProductList(product);}

    @Override
    public void deleteProductByIds(String ids) {
        String[] delIds = ids.split(",");
        if (delIds.length>0){
            for (int i =0;i<delIds.length;i++){
                //获取id的值
                Long id = Long.parseLong(delIds[i].toString());
                //消息发送  product.*
                sendMQMessage("delete",(Long) id);
            }
            this.productMapper.deleteProductByIds(delIds);
        }

    }

    //发送消息的实现
    private void sendMQMessage(String type, Long id) {
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("type",type);
            map.put("productId",id);

            this.rabbitTemplate.convertAndSend("CHINASOFTI_PRODUCT_EXCHANGE","product."+type,MAPPER.writeValueAsString(map));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Override
//    public Product selectProductById(Long productId) {
//        Product product = this.productMapper.selectProductById(productId);
//        return product;
//    }


}

