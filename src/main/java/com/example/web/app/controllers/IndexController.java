package com.example.web.app.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Map; //importe del metodo Map 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap; //importe del metodo ModelMap
import org.springframework.web.bind.annotation.GetMapping; //importe del metodo GetMapping
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web.app.models.Usuario;
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
		model.addAttribute("subtitulo", "Comienza el verdadero cambio desde el controlador");
		model.addAttribute("parrafo", "Estoy cambiando el proyecto a github desde el controlador");
		//map.put("titulo", "Hola Spring Famework con Map!"); //cuerpo con el metodo3
		//mv.addObject("titulo", "Hola Spring Famework con ModelAndView!"); //cuerpo con el metodo4
		//mv.setViewName("index"); //cuerpo con el metodo4
		//return mv;
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Escobar");
		usuario.setEmail("andres@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	/*public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres", "Escobar", "andres@correo.com"));
		usuarios.add(new Usuario("Luisa", "Estupiñan", "luisa@correo.com"));
		usuarios.add(new Usuario("Sandra", "Lopez", "sandra@correo.com"));
		model.addAttribute("titulo", "Listado de usuarios: ");
		model.addAttribute("usuarios", usuarios);*/ //metodo con ArrayList
	public String listar(Model model) {
		/*List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Escobar", "andres@correo.com"),
				new Usuario("Luisa", "Estupiñan", "luisa@correo.com"),
				new Usuario("Carlos", "Restrepo", "carlos@correo.com"),
				new Usuario("Sandra", "Lopez", "sandra@correo.com"));*/
		model.addAttribute("titulo", "Listado de usuarios: ");
		//model.addAttribute("usuarios", usuarios);  //metodo con Arrays.asList
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Escobar", "andres@correo.com"),
				new Usuario("Luisa", "Estupiñan", "luisa@correo.com"),
				new Usuario("Carlos", "Restrepo", "carlos@correo.com"),
				new Usuario("Sandra", "Lopez", "sandra@correo.com"));
		//Con el ModelAttribute esta disponible para los metodos listar, perfil, index.
		//Este metodo es para utilizar en varios metodos y vistas
		
		return usuarios;
		
	}
		
}
