package org.opendevup.model;



import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("enseignant")
public class Enseignant extends Personne implements Serializable{
	
	
	@Column(name="grade")
	private String grade;
	@Column(name="spec")
	private String specialite;
	@Column(name="diplom")
	private String diplome;
    private Boolean dispoEncadrement;
    
    
	@OneToMany(mappedBy="enseignant")
	private Collection<Note> notes;
	
	@OneToMany(mappedBy="enseignant")
	private Collection<Absence> absences;
	  
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="idPFE")
	  private PFE pfe;
	public Collection<Absence> getAbsences() {
		return absences;
	}


	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}

	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Collection<Note> getNotes() {
		return notes;
	}


	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}


	public PFE getPfe() {
		return pfe;
	}


	public void setPfe(PFE pfe) {
		this.pfe = pfe;
	}


	public Boolean getDispoEncadrement() {
		return dispoEncadrement;
	}


	public void setDispoEncadrement(Boolean dispoEncadrement) {
		this.dispoEncadrement = dispoEncadrement;
	}


	public Enseignant(String nom, String prenom, int cin, Date dateNaissance, int age, String email, String adresse,
			int tel, int passport, String login, String password, String grade, String specialite, String diplome,
			Boolean dispoEncadrement) {
		super(nom, prenom, cin, dateNaissance, age, email, adresse, tel, passport, login, password);
		this.grade = grade;
		this.specialite = specialite;
		this.diplome = diplome;
		this.dispoEncadrement = dispoEncadrement;
	}


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	
	
	
	
	
	
	
	

}
