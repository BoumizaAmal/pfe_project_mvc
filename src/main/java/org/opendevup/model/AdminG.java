package org.opendevup.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("adming")
public class AdminG extends Personne implements Serializable{
	
	
	

}
