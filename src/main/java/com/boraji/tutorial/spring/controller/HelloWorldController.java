package com.boraji.tutorial.spring.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

/**
 * @author imssbora
 */
@Controller
public class HelloWorldController {
   
   @ApiOperation(value = "Testing Page")
   @RequestMapping(path={"/"},method=RequestMethod.GET)
   public String sayHello(Model model) {
      model.addAttribute("message","Hello Spring MVC!");
     
      //Java 8 LocalDate
      DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
      LocalDate date=LocalDate.now();
      model.addAttribute("date", date.format(formatter));
      
      return "index";
   }
   
   
   @RequestMapping(path={"/getAll"},method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public List<String> get() {
	   //model.addAttribute("message","Darshan!");
	   return Arrays.asList("Darshan","hello");
	   
   }
   
  
   
   
   
}
