package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		
	Optional<Utilisateur> utOptional= utilisateurRepository.findById(id);
		if(utOptional.isEmpty()) {
			return null;
		}
		else {
			return utOptional.get();
		}
	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		
		Optional<Utilisateur> utOptional= utilisateurRepository.findById(utilisateur.getId());
		
		if(utOptional.isEmpty()) {
			return null;
		}
		else {
			return utilisateurRepository.save(utilisateur);
		}
	}

	@Override
	public void deleteUtilisateur(Long id) {
		
		utilisateurRepository.deleteById(id);

	}

}