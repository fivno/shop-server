package com.example.demo.exception;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constants.Constants;
import com.example.demo.util.JsonUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 定义全局异常检查
 */
public class GlobalExceptionHandler {

    // 捕捉其他所有异常
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public JSONObject globalException() {

        return JsonUtil.errorJSON(Constants.GLOBAL_ERROR);
    }

}
