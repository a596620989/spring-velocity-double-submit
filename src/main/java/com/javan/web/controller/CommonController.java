package com.javan.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javan.security.CSRFTokenManager;

@Controller
public class CommonController {
	
	@RequestMapping(value = "csrf-demo",method=RequestMethod.GET)
	public String demo(ModelMap model,String path) {
		
		if("ajax-get".equals(path)){
			return "/ajax-get";
		}else if("ajax-post".equals(path)){
			return "/ajax-post";
		}else if("multipart".equals(path)){
			return "/multipart";
		}else if("session-overtime".equals(path)){
			return "/session-overtime";
		}
		
		return "/csrf-demo";
	}
	
	@RequestMapping(value = "csrf-submit",method=RequestMethod.POST)
	public String submit(HttpServletRequest request, ModelMap model) {
		String val = request.getParameter("val");
		model.addAttribute("val", val);
		return "csrf-demo";
	}
	
	@RequestMapping(value = "ajax-get",method=RequestMethod.GET)
	public String ajaxGetSubmit(HttpServletRequest request, ModelMap model) {
		String val = request.getParameter("val");
		model.addAttribute("val", val);
		return "success";
	}
	
	@RequestMapping(value = "ajax-post",method=RequestMethod.POST)
	public String ajaxPostSubmit(HttpServletRequest request, ModelMap model) {
		String val = request.getParameter("val");
		model.addAttribute("val", val);
		return "success";
	}
	
	@RequestMapping(value = "another-ajax-post",method=RequestMethod.POST)
	public String anotherAjaxPostSubmit(HttpServletRequest request, ModelMap model) {
		String val = request.getParameter("val");
		model.addAttribute("val", val);
		return "success";
	}
	
	@RequestMapping(value = "multipart",method=RequestMethod.POST)
    public String multipart(MultipartHttpServletRequest request, ModelMap model) {
        String val = request.getParameter("val");
        System.out.println(val);
        
        model.addAttribute("val", val);
        return "success";
    }
	
	
}
