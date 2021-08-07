package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.ShoppingCartService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;



    /**
     * 生成购物车详细信息
     */
    @RequestMapping(value = {"/shoppingCart/shoppingCartData"})
    @ResponseBody
    public JSONArray shoppingCartData(){

        return shoppingCartService.findAllShoppingCart();
    }

    /**
     *
     *获取购物车信息
     */
    @RequestMapping(value = {"/shoppingCart/getShoppingCart"},method=RequestMethod.GET)
    @ResponseBody
    public JSONArray getShoppingCart(HttpServletRequest request){

        //检验用户是否登录
        String userId = request.getParameter("userId");
        HttpSession session=request.getSession();

        if (!userId.equals(request.getSession().getId())){

            JSONObject res=JsonUtil.errorJSON("user not log in!");
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return resArray;

        }
        int id= Integer.parseInt(request.getSession().getAttribute("loginId").toString());


        return shoppingCartService.findByUserId(id);
    }

    /**
     * 插入购物车信息
     */
    @RequestMapping(value = {"/shoppingCart/addShoppingCart"},method=RequestMethod.POST)
    @ResponseBody
    public JSONObject addShoppingCart(@RequestBody JSONObject jsonObject,HttpServletRequest request){

        //检验用户是否登录
        String userId = request.getParameter("userId");
        HttpSession session=request.getSession();

        if (!userId.equals(request.getSession().getId())){

            JSONObject res=JsonUtil.errorJSON("user not log in!");
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return res;

        }

        try{
            shoppingCartService.insert(jsonObject);
        }
        catch (Exception e){

            return JsonUtil.errorJSON("insert error");
        }
        return  JsonUtil.successJSON();
    }


    /**
     * 删除购物车信息
     */
    @RequestMapping(value = {"/shoppingCart/deleteShoppingCart"},method=RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteShoppingCart(@RequestBody JSONObject jsonObject,HttpServletRequest request){

        //检验用户是否登录
        String userId = request.getParameter("userId");
        HttpSession session=request.getSession();

        if (!userId.equals(request.getSession().getId())){

            JSONObject res=JsonUtil.errorJSON("user not log in!");
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return res;

        }
        try{
            int user_id=jsonObject.getInteger("userId");
            int product_id=jsonObject.getInteger("productId");
            shoppingCartService.update(user_id,product_id);
        }
        catch (Exception e){

            return JsonUtil.errorJSON("insert error");
        }
        return  JsonUtil.successJSON();
    }

    /**
     * 更新购物车商品数量
     * @param {Object} ctx
     */
    @RequestMapping(value = {"/shoppingCart/updateShoppingCart"},method=RequestMethod.POST)
    @ResponseBody
    public JSONObject updateShoppingCart(@RequestBody JSONObject jsonObject,HttpServletRequest request){

        //检验用户是否登录
        String userId = request.getParameter("userId");
        HttpSession session=request.getSession();

        if (!userId.equals(request.getSession().getId())){

            JSONObject res=JsonUtil.errorJSON("user not log in!");
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return res;

        }
        try{
            int user_id=jsonObject.getInteger("userId");
            int product_id=jsonObject.getInteger("productId");
            shoppingCartService.update(user_id,product_id);
        }
        catch (Exception e){

            return JsonUtil.errorJSON("update error");
        }
        return  JsonUtil.successJSON();
    }




}
