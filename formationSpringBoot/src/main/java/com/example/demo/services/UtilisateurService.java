package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Utilisateur;


public interface UtilisateurService {

	//méthodes CRUD basique
	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
	
	//méthodes un peu avancées
	
	public List<Utilisateur> findByFirstName(String firtsName);
	public List<Utilisateur> findByFirstNameOrLastName(String firstName,String lastName);
	public List<Utilisateur> findByFirstNameAndLastNameWithJpql(String firstName,String lastName);
	public List<Utilisateur> findByAgeIn(List<Integer> ages);
	public List<Utilisateur> findByStarterDateAndActiveFalse(Date date);
	public List<Utilisateur> findByRoleTitre(String titre);
}
