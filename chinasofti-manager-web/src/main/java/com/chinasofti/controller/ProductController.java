package com.chinasofti.controller;

import com.chinasofti.domain.DataTableJSONResponse;
import com.chinasofti.domain.Product;
import com.chinasofti.service.ProductService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/restful/page")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增商品
     */
    @RequestMapping(value = "product",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> insertProduct(Product product,
                                              @RequestParam(value = "editorValue",required = false) String editorValue){
        try{
            this.productService.insertProduct(product,editorValue);
            //201
            return  ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    /**
     * 显示商品列表信息
     */
    @RequestMapping(value = "product",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DataTableJSONResponse> selectProductList(@RequestParam(value = "aodata",required = false) String aodata,
                                                                   @RequestParam(value = "cid",required = false) Long cid){
        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse();

        try {
            String sEcho="0"; //记录状态
            int iDisplayStart = 0; //起始索引
            int iDisplayLength = 10; //每页显示的记录数

            if(aodata!=null){
                JSONArray jsonArray = new JSONArray(aodata);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                    if (jsonObject.get("name").equals("sEcho")){
                        sEcho=jsonObject.get("value").toString();
                    }
                    if (jsonObject.get("name").equals("iDisplayStart")){
                        iDisplayStart = jsonObject.getInt("value");
                    }
                    if (jsonObject.get("name").equals("iDisplayLength")){
                        iDisplayLength = jsonObject.getInt("value");
                    }
                }
            }

            Product product = new Product();
            if (cid!=null){
                product.setCid(cid);
            }


            List<Product> aadata = this.productService.selectProductList(product);//查询结果
            Integer countWhere = aadata.size();//查询记录数

            //处理分页
            if(countWhere>iDisplayLength){
                if ((countWhere-iDisplayStart)>iDisplayLength){
                    aadata = aadata.subList(iDisplayStart,iDisplayStart+iDisplayLength);
                }else {
                    aadata = aadata.subList(iDisplayStart,countWhere);
                }
            }

            dataTableJSONResponse = new DataTableJSONResponse(sEcho,countWhere,countWhere,aadata);
            return ResponseEntity.status(HttpStatus.OK).body(dataTableJSONResponse);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 批量删除商品
     */
    @RequestMapping(value = "product",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteProductByIds(@RequestParam("ids") String ids){

        try {
            //批量删除方法
            this.productService.deleteProductByIds(ids);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}