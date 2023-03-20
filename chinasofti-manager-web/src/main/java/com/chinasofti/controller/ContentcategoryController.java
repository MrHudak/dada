package com.chinasofti.controller;


import com.chinasofti.domain.Content;
import com.chinasofti.domain.Contentcategory;
import com.chinasofti.domain.DataTableJSONResponse;
import com.chinasofti.service.ContentcategoryService;
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

public class ContentcategoryController {
    @Autowired
    private ContentcategoryService contentcategoryService;
   // private ContentcategoryController contentService;

    /**
     * 查询所有分类列表信息
     */
    @RequestMapping(value = "contentcategory",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Contentcategory>> selectContentList(Contentcategory contentcategory){
        try{
            List<Contentcategory> list = this.contentcategoryService.selectContentcategoryList(contentcategory);
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



    /**
     * 添加分类子类目
     */
    @RequestMapping(value = "contentcategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> insertContentCategory(Contentcategory contentcategory){
        try{
            this.contentcategoryService.insertContentCategory(contentcategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    /**
     * 修改分类类目信息
     */
    @RequestMapping(value = "contentcategory",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Boolean> updateContentCategory(Contentcategory contentcategory){
        try{
            this.contentcategoryService.updateContentCategory(contentcategory);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    /**
     * 批量删除类目
     */
    @RequestMapping(value = "contentcategory",method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Boolean> deleteContentCategory(Contentcategory contentcategory){
        try{
            this.contentcategoryService.deleteContentCategory(contentcategory);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    /**
     * 商品分页列表显示
     */
//    @RequestMapping(value = "content",method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<DataTableJSONResponse> selectContentList(@RequestParam(value = "aodata",required = false) String aodata,
//                                                                   @RequestParam(value = "categoryid",required = false) Long categoryid){
//        DataTableJSONResponse dataTableJSONResponse = new DataTableJSONResponse();
//
//        try {
//            String sEcho="0"; //记录状态
//            int iDisplayStart = 0; //起始索引
//            int iDisplayLength = 10; //每页显示的记录数
//
//            if(aodata!=null){
//                JSONArray jsonArray = new JSONArray(aodata);
//                for (int i=0;i<jsonArray.length();i++){
//                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
//                    if (jsonObject.get("name").equals("sEcho")){
//                        sEcho=jsonObject.get("value").toString();
//                    }
//                    if (jsonObject.get("name").equals("iDisplayStart")){
//                        iDisplayStart = jsonObject.getInt("value");
//                    }
//                    if (jsonObject.get("name").equals("iDisplayLength")){
//                        iDisplayLength = jsonObject.getInt("value");
//                    }
//                }
//            }
//
//            Content content = new Content();
//            if (categoryid!=null){
//                content.setCategoryid(categoryid);
//            }
//
//
//            List<Content> aadata = this.contentService.selectContentList(content);//查询结果
//            Integer countWhere = aadata.size();//查询记录数
//
//            //处理分页
//            if(countWhere>iDisplayLength){
//                if ((countWhere-iDisplayStart)>iDisplayLength){
//                    aadata = aadata.subList(iDisplayStart,iDisplayStart+iDisplayLength);
//                }else {
//                    aadata = aadata.subList(iDisplayStart,countWhere);
//                }
//            }
//
//            dataTableJSONResponse = new DataTableJSONResponse(sEcho,countWhere,countWhere,aadata);
//            return ResponseEntity.status(HttpStatus.OK).body(dataTableJSONResponse);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//    }
}
