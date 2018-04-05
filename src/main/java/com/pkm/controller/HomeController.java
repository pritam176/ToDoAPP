/**
 * 
 */
package com.pkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pkumar
 *
 */
@Controller
public class HomeController {

	@GetMapping("/swagger")
	public String redirectToSwaggerUI() {
		return "redirect:swagger-ui.html";
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test(@RequestParam(value = "text") final String text) {
		return text;
	}
	
	@GetMapping("/")
	public String index() {
		return "html/index";
	}
}
