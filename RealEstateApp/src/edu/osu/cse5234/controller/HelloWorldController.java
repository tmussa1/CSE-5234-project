package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan(basePackages={"edu.osu.cse5234.config" , "edu.osu.cse5234.controller", "edu.osu.cse5234.model"})
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public void  printHello(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		response.getWriter().println("Hello");
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String printHelloNew(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		return "HelloJsp";
	}
}
