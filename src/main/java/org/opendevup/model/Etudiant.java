package org.opendevup.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.opendevup.model.Absence;
import org.opendevup.model.Groupe;
import org.opendevup.model.Note;
import org.opendevup.model.PFE;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends Personne implements Serializable{
	
	
	private int matricule;

	@Column(name="dateinscrit")
	 @Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateInscrit;

	@Column(name="datebac")
	 @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateObtentionBAC;
	@Column(name="situation")
	private String situation;

	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="idPFE")
	  private PFE pfe;
	
	
	@OneToMany(mappedBy="etudiant")
	private Collection<Note> notes;

	@OneToMany(mappedBy="etudiant")
	private Collection<Absence> absences;
	
	public Collection<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="idGrp",referencedColumnName="idGrp",nullable=false,unique=true)
	  private Groupe groupe;
	public PFE getPfe() {
		return pfe;
	}

	public void setPfe(PFE pfe) {
		this.pfe = pfe;
	}

	public Collection<Note> getNotes() {
		return notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}



	public Etudiant(String nom, String prenom, int cin, java.sql.Date dateNaissance, int age, String email,
			String adresse, int tel, int passport, String login, String password, int matricule, Date dateInscrit,
			Date dateObtentionBAC, String situation, PFE pfe, Collection<Note> notes, Collection<Absence> absences,
			Groupe groupe) {
		super(nom, prenom, cin, dateNaissance, age, email, adresse, tel, passport, login, password);
		this.matricule = matricule;
		this.dateInscrit = dateInscrit;
		this.dateObtentionBAC = dateObtentionBAC;
		this.situation = situation;
		this.pfe = pfe;
		this.notes = notes;
		this.absences = absences;
		this.groupe = groupe;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Date getDateInscrit() {
		return dateInscrit;
	}

	public void setDateInscrit(Date dateInscrit) {
		this.dateInscrit = dateInscrit;
	}

	public Date getDateObtentionBAC() {
		return dateObtentionBAC;
	}

	public void setDateObtentionBAC(Date dateObtentionBAC) {
		this.dateObtentionBAC = dateObtentionBAC;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	
	
	
}
