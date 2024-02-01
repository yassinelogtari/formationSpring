package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
	
	public List<Utilisateur> findByFirstName(String firtsName);
	public List<Utilisateur> findByFirstNameOrLastName(String firstName,String lastName);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.firstName = ?1 AND u.lastName = ?2")
	public List<Utilisateur> findByFirstNameAndLastNameWithJpql(String firstName, String lastName);
	
	public List<Utilisateur> findByAgeIn(List<Integer> ages);
	public List<Utilisateur> findByStarterDateAndActiveFalse(Date date);
	
	public List<Utilisateur> findByRolesTitre(String titre);
}
