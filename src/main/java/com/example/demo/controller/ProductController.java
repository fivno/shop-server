package com.example.demo.controller;/**
 * @author yuanzhengyu
 * @date 2021/8/7 - 21:20
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constants.Constants;
import com.example.demo.enity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@description:
 *@author: yuanzhengyu
 *@time: 2021/8/7 21:20
 */

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    //全部商品
    @RequestMapping(value = {"/product/all"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONArray showAllProduct(  ){

        try {
            return productService.findAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject res=JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return resArray;
        }
    }

    //查找一个商品
    @RequestMapping(value = {"/product/findById"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONObject showProductById(  @RequestParam Integer productId ){

        try {
            return productService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject res=JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return res;
        }
    }


    //前端传送“keyword”进行模糊查询
    @RequestMapping(value = {"/product/search"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONArray search( @RequestParam String keyword ){

        try {
            JSONArray arr1 = new JSONArray(  );
            arr1.add( productService.findByProductId( Integer.parseInt( keyword ) ) );
            JSONArray arr2 = productService.findByIntro( keyword );
            JSONArray arr3 = productService.findByName( keyword );
            JSONArray arr4 = productService.findByIntro( keyword );

            return arr1.fluentAddAll( arr2 ).fluentAddAll( arr3 ).fluentAddAll( arr4 );

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject res=JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return resArray;
        }
    }

    //返回后需要刷新页面
    @RequestMapping(value = {"/product/add"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addProduct(@RequestBody Product product ){

        try {
            productService.insert( product );
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
        }
    }

    @RequestMapping(value = {"/product/delete"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteProduct( @RequestParam Integer productId ){

        try {
            productService.deleteById( productId );
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
        }
    }

    @RequestMapping(value = {"/product/update"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateProduct( @RequestBody Product product ){

        try {
            productService.updateById( product.getProductId(), product );
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
        }
    }
    //根据商品种类进行展示
    @RequestMapping(value = {"/product/kind"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONArray showAllProductByKind( @RequestParam String  categoryName ){

        try {
            int categoryId=categoryService.findByCategoryName(categoryName).getInteger("categoryId");
            return productService.findByCategoryId( categoryId );

        } catch (Exception e) {
            e.printStackTrace();
            JSONObject res=JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return resArray;
        }
    }

}
