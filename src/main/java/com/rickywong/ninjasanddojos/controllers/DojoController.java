package com.rickywong.ninjasanddojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rickywong.ninjasanddojos.models.Dojo;
import com.rickywong.ninjasanddojos.models.Ninja;
import com.rickywong.ninjasanddojos.services.DojoService;
import com.rickywong.ninjasanddojos.services.NinjaService;



@Controller
public class DojoController {
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	
	public DojoController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/new.jsp";
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/new.jsp";
		}
		else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	@RequestMapping("ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("dojos", dojoServ.allDojos());
		model.addAttribute("ninja", new Ninja());
		return "ninja/new.jsp";
	}

	@RequestMapping(value="ninjas/create", method=RequestMethod.POST)
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		ninjaServ.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	// Showing information
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		List<Ninja> ninjas = ninjaServ.allNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "dojo/show.jsp";
	}
	
	
	
	
	
	
}
