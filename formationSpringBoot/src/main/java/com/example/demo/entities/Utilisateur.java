package com.example.demo.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.Table;

import jakarta.persistence.*;


@Entity
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate starterDate;
	private int age;
	private Boolean active;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE} )
	private Contact contact;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set <Role> roles ;
	
	@OneToMany (cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},fetch = FetchType.EAGER)
	private Set<Adresse> adresses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getStarterDate() {
		return starterDate;
	}
	public void setStarterDate(LocalDate starterDate) {
		this.starterDate = starterDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}
	
	
	

}
