package org.opendevup.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pfe")
public class PFE implements Serializable{
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "idPFE")
		private long idPFE;
		private String nomPrenom;
		private String nomPrenomBinome;
		private String sujet;
		private String societeAccueil;
		private String encadreur;
		@Column(name = "date_deb")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date dateDeb;
		@Column(name = "date_fin")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date dateFin;
		@OneToMany(mappedBy="pfe")
		private Collection<Etudiant> etudiants;
		
		@OneToMany(mappedBy="pfe")
		private Collection<Enseignant> enseignants;

		public PFE(long idPFE, String nomPrenom, String nomPrenomBinome, String sujet, String societeAccueil,
				String encadreur, Date dateDeb, Date dateFin, Collection<Etudiant> etudiants,
				Collection<Enseignant> enseignants) {
			super();
			this.idPFE = idPFE;
			this.nomPrenom = nomPrenom;
			this.nomPrenomBinome = nomPrenomBinome;
			this.sujet = sujet;
			this.societeAccueil = societeAccueil;
			this.encadreur = encadreur;
			this.dateDeb = dateDeb;
			this.dateFin = dateFin;
			this.etudiants = etudiants;
			this.enseignants = enseignants;
		}

		public PFE() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getIdPFE() {
			return idPFE;
		}

		public void setIdPFE(long idPFE) {
			this.idPFE = idPFE;
		}

		public String getNomPrenom() {
			return nomPrenom;
		}

		public void setNomPrenom(String nomPrenom) {
			this.nomPrenom = nomPrenom;
		}

		public String getNomPrenomBinome() {
			return nomPrenomBinome;
		}

		public void setNomPrenomBinome(String nomPrenomBinome) {
			this.nomPrenomBinome = nomPrenomBinome;
		}

		public String getSujet() {
			return sujet;
		}

		public void setSujet(String sujet) {
			this.sujet = sujet;
		}

		public String getSocieteAccueil() {
			return societeAccueil;
		}

		public void setSocieteAccueil(String societeAccueil) {
			this.societeAccueil = societeAccueil;
		}

		public String getEncadreur() {
			return encadreur;
		}

		public void setEncadreur(String encadreur) {
			this.encadreur = encadreur;
		}

		public Date getDateDeb() {
			return dateDeb;
		}

		public void setDateDeb(Date dateDeb) {
			this.dateDeb = dateDeb;
		}

		public Date getDateFin() {
			return dateFin;
		}

		public void setDateFin(Date dateFin) {
			this.dateFin = dateFin;
		}

		public Collection<Etudiant> getEtudiants() {
			return etudiants;
		}

		public void setEtudiants(Collection<Etudiant> etudiants) {
			this.etudiants = etudiants;
		}

		public Collection<Enseignant> getEnseignants() {
			return enseignants;
		}

		public void setEnseignants(Collection<Enseignant> enseignants) {
			this.enseignants = enseignants;
		}

		
		
		
		
	}


