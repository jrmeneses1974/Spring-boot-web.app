package com.example.web.app.controllers;

//import java.util.Map; //importe del metodo Map 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap; //importe del metodo ModelMap
import org.springframework.web.bind.annotation.GetMapping; //importe del metodo GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping; //Importe del metodo RequestMapping
//import org.springframework.web.servlet.ModelAndView; //importe del metodo ModelAndView
//import org.springframework.web.bind.annotation.RequestMethod; //Importe del metodo1

@Controller
@RequestMapping("/app")
public class IndexController {
	
	//@RequestMapping(value="/index", method=RequestMethod.GET) //metodo1
	//@GetMapping(value="/index") // con value
	@GetMapping({"/index", "/", "", "/home"}) //sin value
	public String index(Model model) { //metodo1 con Model
	//public String index(ModelMap model) { //metodo2 con ModelMap
	//public String index(Map<String, Object> map) { //metodo3 con Map
	//public ModelAndView index(ModelAndView mv) { //metodo4 
		model.addAttribute("titulo", "Hola Spring Famework con model!"); //Cuerpo del metodo1y2
		//map.put("titulo", "Hola Spring Famework con Map!"); //cuerpo con el metodo3
		//mv.addObject("titulo", "Hola Spring Famework con ModelAndView!"); //cuerpo con el metodo4
		//mv.setViewName("index"); //cuerpo con el metodo4
		//return mv;
		return "index";
	}
}
