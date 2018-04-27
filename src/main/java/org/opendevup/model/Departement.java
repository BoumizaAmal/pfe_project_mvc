package org.opendevup.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.opendevup.model.Filiere;

@Entity
@Table(name="departement")
public class Departement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDept")
	private long idDept;
	private String nom;
	private String chefDepartment;
	private String secretaire;
	@Column(name = "nbrTechnicien")
	private int nbrTechnicien;
	@Column(name = "nbrBureaux")
	private int nbrBureaux;
	
	@OneToMany(mappedBy = "dept")
	  private Collection<Filiere> filieres;
	
	public Collection<Filiere> getFilieres() {
		return filieres;
	}
	public void setFilieres(Collection<Filiere> filieres) {
		this.filieres = filieres;
	}
	
	public Departement(long idDept, String nom, String chefDepartment, String secretaire, int nbrTechnicien,
			int nbrBureaux) {
		super();
		this.idDept = idDept;
		this.nom = nom;
		this.chefDepartment = chefDepartment;
		this.secretaire = secretaire;
		this.nbrTechnicien = nbrTechnicien;
		this.nbrBureaux = nbrBureaux;
		
	}
	
	
	
	public String getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(String secretaire) {
		this.secretaire = secretaire;
	}
	public int getNbrTechnicien() {
		return nbrTechnicien;
	}
	public void setNbrTechnicien(int nbrTechnicien) {
		this.nbrTechnicien = nbrTechnicien;
	}
	public int getNbrBureaux() {
		return nbrBureaux;
	}
	public void setNbrBureaux(int nbrBureaux) {
		this.nbrBureaux = nbrBureaux;
	}
	public String getChefDepartment() {
		return chefDepartment;
	}
	public void setChefDepartment(String chefDepartment) {
		this.chefDepartment = chefDepartment;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdDept() {
		return idDept;
	}
	public void setIdDept(long idDept) {
		this.idDept = idDept;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
