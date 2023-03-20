package com.chinasofti.service.impl;

//import com.alibaba.dubbo.config.annotation.Service;
import com.chinasofti.domain.Contentcategory;
import com.chinasofti.mapper.ContentcategoryMapper;
import com.chinasofti.service.ContentcategoryService;
import com.chinasofti.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentcategoryServiceImpl implements ContentcategoryService {

    @Autowired
    private ContentcategoryMapper contentcategoryMapper;

    @Override
    public List<Contentcategory> selectContentcategoryList(Contentcategory contentcategory) {
        return contentcategoryMapper.selectContentcategoryList(contentcategory);
    }

    @Override
    public void insertContentCategory(Contentcategory contentcategory) {
        this.contentcategoryMapper.insertContentcategory(contentcategory);
    }

    @Override
    public void updateContentCategory(Contentcategory contentcategory) {
        this.contentcategoryMapper.updateContentcategory(contentcategory);
    }

    @Override
    public void deleteContentCategory(Contentcategory contentcategory) {

        //获取全部删除id
        List<Object> idslist = new ArrayList<>();
        //添加当前类目
        idslist.add(contentcategory.getId());

        //递归所有的类目id
        findSubNode(idslist,contentcategory.getId());

        StringBuffer sb = new StringBuffer();
        //执行删除id
        for (Object obj:idslist){
            sb.append(obj.toString()+",");
        }
        sb.deleteCharAt(sb.length()-1);

        this.contentcategoryMapper.deleteContentcategoryByIds(Convert.toStrArray(sb.toString()));
    }

    private void findSubNode(List<Object> idslist,Long id) {

        Contentcategory contentcategory =  new Contentcategory();
        contentcategory.setParentid(id);

        //查询当前类目下的所有子类目
        List<Contentcategory> list = this.contentcategoryMapper.selectContentcategoryList(contentcategory);

        //查询所有当前类目的子类目
        for(Contentcategory contentcategory2 : list){
            idslist.add(contentcategory2.getId());

            //递归所有子类目
            findSubNode(idslist,contentcategory2.getId());
        }

    }
}
