package org.opendevup.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.opendevup.model.Enseignant;
import org.opendevup.model.Etudiant;
import org.opendevup.model.Matiere;

@Entity
@Table(name="absence")
public class Absence implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAbs")
	private long idAbs;
	private Date date;
	
	private String heure;
	private String nomMatiere;
	private String excuse;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="idMatiere",referencedColumnName="idMatiere",nullable=false,unique=true)
	  private Matiere matiere;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id", referencedColumnName="id",nullable=false, updatable=false, insertable=false)
	private Enseignant enseignant;

	@ManyToOne(optional=false)
	@JoinColumn(name="id", referencedColumnName="id", nullable=false, updatable=false, insertable=false)
	private Etudiant etudiant;

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(long idAbs, Date date, String heure, String nomMatiere, String excuse, Matiere matiere) {
		super();
		this.idAbs = idAbs;
		this.date = date;
		this.heure = heure;
		this.nomMatiere = nomMatiere;
		this.excuse = excuse;
		this.matiere = matiere;
	}

	public long getIdAbs() {
		return idAbs;
	}

	public void setIdAbs(long idAbs) {
		this.idAbs = idAbs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getExcuse() {
		return excuse;
	}

	public void setExcuse(String excuse) {
		this.excuse = excuse;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	

	
}
