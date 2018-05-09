package com.ssm.controller;

import com.ssm.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTest {
	
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom转成json输出
	@RequestMapping("/requestJson")
	@ResponseBody
	public  ItemsCustom requestJson(ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;
	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	@ResponseBody
	public  ItemsCustom responseJson(ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom转成json输出
		return itemsCustom;
	}

}
