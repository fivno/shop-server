package com.example.demo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JsonUtil {

    @NotNull
    public static <T> JSONArray list2JSONArray(List<T> list){

        JSONArray jsonArray=new JSONArray();

        for(T j:list){
              jsonArray.add(j);
        }

        return jsonArray;
    }


}
