package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the REGROUPEMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Regroupement.findAll", query="SELECT r FROM Regroupement r")
public class Regroupement extends EcritureCahier implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String type;
		
	//bi-directional many-to-one association to Evenement
	@OneToMany (cascade=CascadeType.ALL)
	private List<Evenement> evenements = new ArrayList<>();

	public Regroupement() {}

	public Regroupement(String type, String libelle, Date debut, List<Evenement> evenements) {
		super(libelle, debut);
		this.type = type;
		if(evenements != null) this.evenements = evenements;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Evenement> getEvenements() {
		return this.evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Evenement addEvenement(Evenement evenement) {
		getEvenements().add(evenement);
		return evenement;
	}

	public Evenement removeEvenement(Evenement evenement) {
		getEvenements().remove(evenement);
		return evenement;
	}

	@Override
	public String toString() {
		return "Regroupement [type=" + type + ", evenements=" + evenements + "]";
	}

}