package com.duke.model;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Author: duke
 * Date: 2017/8/11 下午5:43
 */
@Component
public class BeanView implements View{

	@Override
	public String getContentType() {
		return "text/html;charset=UTF-8";
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest httpServletRequest,
	                   HttpServletResponse httpServletResponse) throws Exception {
		System.out.println("BeanView");
		httpServletResponse.getWriter().print("还是 Welcome to View:"+new Date());

	}
}
