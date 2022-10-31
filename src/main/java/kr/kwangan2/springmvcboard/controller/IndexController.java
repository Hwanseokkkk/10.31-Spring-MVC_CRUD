package kr.kwangan2.springmvcboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
public class IndexController {
	
		@GetMapping("/")
		public String index(String result) {
			log.info("result==========================================>"+result);
			return "redirect:/";
		}
}
