package com.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangxin on 2018/5/8.
 */
public class CustomExceptionResolvers implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException customException=null;
        if(e instanceof CustomException){
            customException=(CustomException)e;

        }else{
            customException=new CustomException("未知异常");
        }
        //错误信息
        String message=customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();

        //将错误信息传到页面
        modelAndView.addObject("message", message);

        //指向错误页面
        modelAndView.setViewName("error");


        return modelAndView;
    }
}
