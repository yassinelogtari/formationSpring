package com.example.demo.cotroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utilisateur;
import com.example.demo.requests.FirstNameAndLastNameRequest;
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
	public ResponseEntity<Utilisateur>  getOne(@PathVariable Long id) {
		
		Utilisateur utilisateur= utilisateurservice.findUtilisateurById(id);
		if(utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
		}
	}
	
	//findbyFirstName
	@GetMapping	("/getByFirstName/{firstName}")
	public ResponseEntity<List<Utilisateur>> findUtilisateursByFirstName(@PathVariable String firstName) {
		
		List<Utilisateur> utilisateurs= utilisateurservice.findByFirstName(firstName);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
		}
	}
	
	//findUtilisateursByFirstNameOrLastName
	@GetMapping	("/getByFirstNameOrLastName/{firstName}/{lastName}")
	public ResponseEntity<List<Utilisateur>> findUtilisateursByFirstNameOrLastName(@PathVariable String firstName,@PathVariable String lastName) {
		
		List<Utilisateur> utilisateurs= utilisateurservice.findByFirstNameOrLastName(firstName, lastName);
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
		}
	}
	
	//findUtilisateursByFirstNameOrLastName with @requestbody
	@GetMapping	("/getByFirstNameOrLastNameWithRb")
	public ResponseEntity<List<Utilisateur>> findUtilisateursByFirstNameOrLastNameWithRb(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
		
		List<Utilisateur> utilisateurs= utilisateurservice.findByFirstNameOrLastName(firstNameAndLastNameRequest.getFirstName(),firstNameAndLastNameRequest.getLastName());
		if(utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
		}
	}
	
	
	//findUtilisateursByFirstNameOrLastName with @requestbody with jpql
		@GetMapping	("/getByFirstNameOrLastNameWithJpql")
		public ResponseEntity<List<Utilisateur>> findUtilisateursByFirstNameOrLastNameWithRbJpql(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
			
			List<Utilisateur> utilisateurs= utilisateurservice.findByFirstNameAndLastNameWithJpql(firstNameAndLastNameRequest.getFirstName(),firstNameAndLastNameRequest.getLastName());
			if(utilisateurs.isEmpty()) {
				return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
			}
		}
		
	//	findUtilisateursByAges with @requestbody 
		@GetMapping	("/getByAge")
		public ResponseEntity<List<Utilisateur>> findUtilisateursAge(@RequestBody List<Integer> ages) {
			
			List<Utilisateur> utilisateurs= utilisateurservice.findByAgeIn(ages);
			if(utilisateurs.isEmpty()) {
				return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
			}
		}
	
//		findUtilisateursByStarterDateAndAvtiveFalse
			@GetMapping	("/getByStarterDate/{date}")
			public ResponseEntity<List<Utilisateur>> findUtilisateursByStarterDateAndAvtiveFalse(@PathVariable	 Date date) {
				
				List<Utilisateur> utilisateurs= utilisateurservice.findByStarterDateAndActiveFalse(date);
				if(utilisateurs.isEmpty()) {
					return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
				}
			}	
		
//			findUtilisateursByStarterDateAndAvtiveFalse
				@GetMapping	("/getByRole/{titre}")
				public ResponseEntity<List<Utilisateur>> findUtilisateursByRole(@PathVariable String titre) {
					
					List<Utilisateur> utilisateurs= utilisateurservice.findByRoleTitre(titre);
					if(utilisateurs.isEmpty()) {
						return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
					}
					else {
						return new ResponseEntity<List<Utilisateur>>(utilisateurs,HttpStatus.OK);
					}
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



