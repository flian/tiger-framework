package com.tiger.framework.controller;

import com.tiger.framework.datamodel.Category;
import com.tiger.framework.dbservice.ICategoryService;
import com.tiger.framework.dto.RESTResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by foy on 2016-06-07.
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Resource(name="categoryService")
    ICategoryService categoryService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String page(){
        return "categories/tree";
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public Object categoriesJson(){
        return categoryService.all();
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object saveOrUpdateOrDelete(Category category,@RequestParam(value = "op",defaultValue = "u") String op,
                                         @RequestParam(value = "categoryId",defaultValue = "0") long categoryId){
        Category result=null;
        switch (op){
            case "u":{
                categoryService.update(category);
                return category;
            }
            case "c":{
                category.setCategoryId(null);
                categoryService.save(category);
                return category;
            }
            case "d":{
                categoryService.delete(categoryId);
                RESTResponseDTO rs=new RESTResponseDTO();
                rs.setProcCode(200);
                rs.setMessage("delete success!");
                return rs;
            }

        }
        return result;
    }
}
