package com.jinhu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinhu.config.RootConfig;
import com.jinhu.service.AuthorService;

@Controller
public class AuthorController {
	private static final Logger logger = LoggerFactory.getLogger(RootConfig.class);
	@Autowired
	private AuthorService authorService;
	
	public AuthorController(){
	}
	
	@RequestMapping(value="/author/{id}",method=RequestMethod.GET)
	public String find(@PathVariable("id") int id,Model model){
		model.addAttribute("author", authorService.findById(id));
		return "author";
	}
}
