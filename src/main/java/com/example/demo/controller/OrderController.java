package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.OrdersService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class OrderController {

    @Autowired
    OrdersService ordersService;

    /**
     * 获取用户的所有订单信息
     *
     */
    @RequestMapping(value = {"/order/getOrder"},method= RequestMethod.GET)
    @ResponseBody
    public JSONArray getOrder(HttpServletRequest request){

        //检验用户是否登录
        String userId = request.getParameter("userId");
        HttpSession session=request.getSession();

        if (!userId.equals(request.getSession().getId())){

            JSONObject res= JsonUtil.errorJSON("user not log in!");
            JSONArray resArray=new JSONArray();
            resArray.add(res);
            return resArray;

        }
        int id= Integer.parseInt(request.getSession().getAttribute("loginId").toString());


        return ordersService.findByUserId(id);
    }



    /**
     * 添加用户订单信息
     *
     */

    @RequestMapping(value = {"/order/addOrder"},method=RequestMethod.POST)
    @ResponseBody
    public JSONObject addOrder(@RequestBody JSONObject jsonObject, HttpServletRequest request){

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
            ordersService.insert(jsonObject);
        }
        catch (Exception e){

            return JsonUtil.errorJSON("insert error");
        }
        return  JsonUtil.successJSON();
    }



}
