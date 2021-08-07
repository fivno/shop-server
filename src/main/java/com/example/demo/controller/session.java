package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class session {

    @RequestMapping(value = {"/session"},method= RequestMethod.GET)
    @ResponseBody
    public void setSession(HttpSession session){

        session.setAttribute("userId", 1);
        //session.
        System.out.println(session.getAttribute("userId"));
    }
    @RequestMapping(value = {"/get"},method= RequestMethod.GET)
    @ResponseBody
    public Integer getSession(HttpSession session){

        int id=Integer.parseInt(session.getAttribute("userId").toString());

        System.out.println(session.getAttribute("userId"));

        return id;
    }


}
