package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Utilisateur;


public interface UtilisateurService {

	public List<Utilisateur> getAllUtilisateurs();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void deleteUtilisateur(Long id);
}
