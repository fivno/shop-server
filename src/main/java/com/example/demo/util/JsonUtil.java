package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.enity.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JsonUtil {

    //list转换为JSONArray
    @NotNull
    public static <T> JSONArray list2JSONArray(List<T> list){

        JSONArray jsonArray=new JSONArray();

        for(T j:list){
              jsonArray.add(j);
        }

        return jsonArray;
    }

    //实体类转换为JSONObject
    @NotNull
    public static <T> JSONObject Object2JSONObject(T Obj){

        String json= JSONObject.toJSONString(Obj);

        return JSONObject.parseObject(json);

    }


    //JSONObject转换为carousel对象
    @NotNull
    public static carousel JSONObject2carousel(JSONObject carouselJSON){

        Integer carouselId=carouselJSON.getInteger("carouselId");
        String imgPath=carouselJSON.getString("imgPath");
        String describes=carouselJSON.getString("describes");

        carousel Obj=new carousel(carouselId,imgPath,describes);

        return Obj;

    }
    //JSONObject转换为category对象
    @NotNull
    public static category JSONObject2category (JSONObject categoryJSON){

        Integer categoryId=categoryJSON.getInteger("categoryId");
        String  categoryName=categoryJSON.getString("categoryName");

        category Obj=new category(categoryId,categoryName);
        return Obj;
    }

    //JSONObject转换为collect对象
    @NotNull
    public static collect JSONObject2collect (JSONObject collectJSON){

        Integer id=collectJSON.getInteger("id");
        Integer userId=collectJSON.getInteger("userId");
        Integer productId=collectJSON.getInteger("productId");
        Integer collectTime=collectJSON.getInteger("collectTime");

        collect Obj=new collect(id,userId,productId,collectTime);
        return Obj;
    }

    //JSONObject转换为orders对象
    @NotNull
    public static orders JSONObject2orders (JSONObject ordersJSON){

        Integer id=ordersJSON.getInteger("id");
        Integer orderId=ordersJSON.getInteger("orderId");
        Integer userId=ordersJSON.getInteger("userId");
        Integer productId=ordersJSON.getInteger("productId");
        Integer productNum=ordersJSON.getInteger("productNum");
        Double productPrice=ordersJSON.getDouble("productPrice");
        Integer orderTime=ordersJSON.getInteger("orderTime");

        orders Obj=new orders(id,orderId,userId,productId,productNum,productPrice,orderTime);
        return Obj;
    }
    //JSONObject转换为product对象
    @NotNull
    public static product JSONObject2product (JSONObject productJSON){

        Integer productId=productJSON.getInteger("productId");
        String productName=productJSON.getString("productName");
        Integer categoryId=productJSON.getInteger("categoryId");
        String productTitle=productJSON.getString("productTitle");
        String productIntro=productJSON.getString("productIntro");
        String productPicture=productJSON.getString("productPicture");
        Double productPrice=productJSON.getDouble("productPrice");
        Double productSellingPrice=productJSON.getDouble("productSellingPrice");
        Integer productNum=productJSON.getInteger("productNum");
        Integer productSales=productJSON.getInteger("productSales");

        product Obj=new product(productId,productName,categoryId,productTitle,productIntro,
                productPicture,productPrice,productSellingPrice,productNum,productSales
                );
        return Obj;
    }

    //JSONObject转换为product_picture对象
    @NotNull
    public static product_picture JSONObject2product_picture (JSONObject product_pictureJSON){

        Integer id=product_pictureJSON.getInteger("id");
        Integer productId=product_pictureJSON.getInteger("productId");
        String productPicture=product_pictureJSON.getString("productPicture");
        String intro=product_pictureJSON.getString("intro");


        product_picture Obj=new product_picture(id,productId,productPicture,intro);
        return Obj;
    }

    //JSONObject转换为shoppingCart对象
    @NotNull
    public static shoppingCart JSONObject2shoppingCart (JSONObject shoppingCartJSON){

        Integer id=shoppingCartJSON.getInteger("id");

        Integer userId=shoppingCartJSON.getInteger("userId");

        Integer productId=shoppingCartJSON.getInteger("productId");

        Integer num=shoppingCartJSON.getInteger("num");


        shoppingCart Obj=new shoppingCart(id,userId,productId,num);
        return Obj;
    }

    //JSONObject转换为users对象
    @NotNull
    public static users JSONObject2users (JSONObject usersJSON){

        Integer userId=usersJSON.getInteger("userId");
        String userNameString=usersJSON.getString("userNameString");
        String password=usersJSON.getString("password");
        String userPhoneNumber=usersJSON.getString("userPhoneNumber");


        users Obj=new users();
        return Obj;
    }


}
