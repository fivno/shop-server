package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constants.Constants;
import com.example.demo.enity.Users;
import com.example.demo.service.UsersService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *用户登录
 *用户注册
 * 查找是否存在重名
 */


@RestController
public class UserController {


    @Autowired
    UsersService usersService;


    /**
     * 用户登录
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = {"/user/login"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            JSONObject res=usersService.login(jsonObject);

            // 如果登录成功，将管理账号添加到 Session对象中保存
            Users user=usersService.findByUserNameOne(res.getString("userName"));

            session.setAttribute("userId", user.getUserId());
            return res;

        } catch (Exception e) {

            e.printStackTrace();

            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);

        }


    }


    /**
     * 用户注册
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = {"/user/register"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(@RequestBody JSONObject jsonObject) {

        try {

            return usersService.register(jsonObject);

        } catch (Exception e) {

            e.printStackTrace();

            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);

        }
    }

    @RequestMapping(value = {"/user/existingName"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject existingName(@RequestBody JSONObject jsonObject) {

        try {

            if (usersService.isUserNameExisting(jsonObject.toJSONString())) {
                return JsonUtil.successJSON();
            } else {
                return JsonUtil.errorJSON("username don't exist!");
            }

        } catch (Exception e) {

            e.printStackTrace();

            return JsonUtil.errorJSON(Constants.GLOBAL_EXCEPTION);

        }

    }

    @RequestMapping("/user/logout")
    @ResponseBody
    public JSONObject logout(HttpSession session) {

        // 销毁 Session对象
        session.invalidate();

        // 返回登录页面重新输入
        return JsonUtil.errorJSON("success logout!");

    }

//    @RequestMapping(value = {"/user/update"}, method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject update(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
//
//        //检验用户是否登录
//        String userId = request.getParameter("userId");
//        HttpSession session=request.getSession();
//
//        if (!userId.equals(request.getSession().getId())){
//
//            JSONObject res=JsonUtil.errorJSON("user not log in!");
//            JSONArray resArray=new JSONArray();
//            resArray.add(res);
//            return res;
//
//        }
//
//
//
//
//        // 返回登录页面重新输入
//        return JsonUtil.errorJSON("success logout!");
//
//    }



}
