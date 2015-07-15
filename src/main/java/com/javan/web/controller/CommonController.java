package com.javan.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class CommonController {
	
	@RequestMapping(value = "demo",method=RequestMethod.GET)
	public String demo(ModelMap model,String path) {
		
		if("ajax-get".equals(path)){
			return "/ajax-get";
		}else if("ajax-post-single".equals(path)){
            return "/ajax-post-single";
        }else if("ajax-post-multi".equals(path)){
			return "/ajax-post-multi";
		}else if("form-multi-form".equals(path)){
            return "/form-multi-form";
        }else if("form-multipart".equals(path)){
			return "form-multipart";
		}
		
		return null;
	}
	
	
	@RequestMapping(value = "ajax-get",method=RequestMethod.GET)
	public String ajaxGetSubmit(HttpServletRequest request, ModelMap model) {
		
		sleepWithMe();
		return "success";
	}
	
	@RequestMapping(value = "ajax-post",method=RequestMethod.POST)
	public String ajaxPostSubmit(HttpServletRequest request, ModelMap model) {
		
		sleepWithMe();
		return "success";
	}
	
	@RequestMapping(value = "another-ajax-post",method=RequestMethod.POST)
	public String anotherAjaxPostSubmit(HttpServletRequest request, ModelMap model) {
		
		sleepWithMe();
		return "success";
	}
	
	@RequestMapping(value = "multipart",method=RequestMethod.POST)
    public String multipart(MultipartHttpServletRequest request, ModelMap model) {
        
        sleepWithMe();
        return "success";
    }
	
	@RequestMapping(value = "form1",method=RequestMethod.POST)
    public String form1(HttpServletRequest request, ModelMap model) {
        
        sleepWithMe();
        return "success";
    }
	
	@RequestMapping(value = "form2",method=RequestMethod.POST)
    public String form2(HttpServletRequest request, ModelMap model) {
        
        sleepWithMe();
        return "success";
    }
	
	
	private void sleepWithMe(){
	    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
