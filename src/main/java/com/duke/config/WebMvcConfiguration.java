package com.duke.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;

/**
 * Author: duke
 * Date: 2017/8/10 下午4:47
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	//favorPathExtension表示支持后缀匹配
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("addViewControllers {}",registry);
		registry.addViewController("/view").setViewName("/view");
	}


}
