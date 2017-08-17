package com.duke.controller;

import com.duke.model.AuthorSetting;
import com.duke.mspringboot2.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.UnsupportedEncodingException;

/**
 * Author: duke
 * Date: 2017/8/9 下午4:03
 */
@Controller
@SpringBootApplication(scanBasePackages = "com.duke")
@ServletComponentScan
//@ComponentScan({"com.duke.model","com.duke.config"})
//@EnableConfigurationProperties(com.duke.model.AuthorSetting.class)
public class DemoController {

	@Value("${book.author}")
	private String bookAuthor;

	@Value("${book.name}")
	private String bookName;

	@Autowired
	private AuthorSetting authorSetting;

	@Autowired
	private HelloService helloService;

	@RequestMapping("/book")
	@ResponseBody
	public String getString(){
		return "book name is " + bookName + " and author is " + bookAuthor + " and " +
		       "author age is " +authorSetting.getAge();
	}

	@RequestMapping(value = "/hello",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getHello(){
		String hello = helloService.sayHello();
		System.out.println(hello);
		return hello;
	}

	@RequestMapping(value = "/word")
	@ResponseBody
	public String getWord(){
		return "试试";
	}

	@RequestMapping(value = "/model",produces = "text/html;charset=UTF-8")
	public String getModel(Model model){
		model.addAttribute("hello",helloService.sayHello());
		return "hello";
	}

	@RequestMapping(value = "/bean",produces = "text/html;charset=UTF-8")
	public String getBeanView(Model model){
		model.addAttribute("hello",helloService.sayHello());
		return "beanView";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoController.class,args);
	}
}
