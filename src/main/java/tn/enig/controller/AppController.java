package tn.enig.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.model.Livre;
import tn.enig.service.ILivreService;

@Controller
public class AppController {
	
	@Autowired // ninjectiha ma8er qualification 5ater jeya mn class 
	ILivreService service; // madem injection lezemhom setter
	
	public void setService(ILivreService service) {
		this.service = service;
	}
	
	
	// l mapping wl handler yet5edmou fl controller
	//donc je doit donner c'est quoi le mapping et comment je peut acceder a une mth fl controller
	//@GetMapping("/home") // hathi fl version 5
			   //hatha l path:url -|   w hathi l meth -|
	@RequestMapping(value="/accueil",method=RequestMethod.GET)
	public String get1(Model m) {
		
		List<Livre> liste = service.getAllLires();
		// l model howa l ensemble des info l mechyin m3a req
		m.addAttribute("liste",liste);
		return "home";
	}

}
