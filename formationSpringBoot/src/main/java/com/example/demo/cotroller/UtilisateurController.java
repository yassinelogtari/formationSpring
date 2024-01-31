package com.example.demo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utilisateur;
import com.example.demo.services.UtilisateurService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurservice;
	
	@GetMapping("/getAll")
	public List<Utilisateur> getAll() {
		return utilisateurservice.getAllUtilisateurs();
	}
	
	@GetMapping	("/getOne/{id}")
	public Utilisateur getOne(@PathVariable Long id) {
		return utilisateurservice.findUtilisateurById(id);
	}
	
	
	@PostMapping("/addUser")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur){
		return utilisateurservice.createUtilisateur(utilisateur);
	}
	
	
	@PutMapping("/updateUser")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurservice.updateUtilisateur(utilisateur);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteUtilisateur(@PathVariable Long id) {
		utilisateurservice.deleteUtilisateur(id);
	}
}



