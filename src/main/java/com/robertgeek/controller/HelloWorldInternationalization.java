package com.robertgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldInternationalization {

	@Autowired
	private MessageSource ms;
	
	@GetMapping(path = "hello-world-2")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "hello-world-internationalization")
	public String goodMorning() {
		return ms.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
	
}
