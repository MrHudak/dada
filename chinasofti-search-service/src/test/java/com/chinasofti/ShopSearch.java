package com.chinasofti;

import com.chinasofti.dao.ProductEsDao;
import com.chinasofti.domain.Product;
import com.chinasofti.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
 @RunWith(SpringRunner.class)
 public class ShopSearch {

    @Autowired
    private ProductMapper pm;

    @Autowired
    private ProductEsDao ped;

    @Test
    public void elastictest() {

         /*Pageable pageable = Pageable.ofSize(3).withPage(0);
15 ped.findByTitle("三星",pageable).getContent().forEach(x->
System.out.println(x));*/
        List<Product> products = pm.selectProductList(null);
        System.out.println(products.size());
        for (int i = 0; i <= 10; i++) {
            //添加数据到索引库
            ped.save(products.get(i));
        }
        //ped.saveAll(products);
        //ped.deleteAll();
    }
}
