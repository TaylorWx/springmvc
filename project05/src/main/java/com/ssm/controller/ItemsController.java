package com.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ssm.exception.CustomException;
import com.ssm.po.ItemsCustom;
import com.ssm.po.ItemsQueryVo;
import com.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	// 商品分类
	//itemtypes表示最终将方法返回值放在request中的key

	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		//测试forward后request是否可以共享
		
		System.out.println(request.getParameter("id"));

		// 调用service查找 数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;

	}
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes() {

		Map<String, String> itemTypes = new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");

		return itemTypes;
	}
	@RequestMapping(value = "/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(
			Model model,
			@RequestParam(value= "id",required=true) Integer id
			)throws Exception {

		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		// 返回ModelAndView
		if(itemsCustom==null){
			throw new CustomException("修改的商品部存在");
		}
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,
								  Integer id,
								  ItemsCustom itemsCustom,
								  MultipartFile items_pic)throws Exception {

		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		if(items_pic!=null&& originalFilename!=null && originalFilename.length()>0){
			//存储图片的物理路径
			String pic_path = "H:\\picture\\";

			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);

			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);

			//将新图片名称写到itemsCustom中
			itemsCustom.setPic(newFileName);
		}
		//System.out.println("jjjjjjjjjjjjjj");
		//重定向到商品查询列表
		//return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		itemsService.updateItems(id, itemsCustom);
		return "success";
	}
}
