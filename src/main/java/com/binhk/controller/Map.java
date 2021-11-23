package com.binhk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Map {
	
	@RequestMapping(value = "/Map", method = RequestMethod.GET)
	public String map(Model model, String localName) {

		model.addAttribute("localName", localName);

		return "map";

	}
}
	
