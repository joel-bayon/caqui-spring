package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the REGIME_SAISONNIER database table.
 * 
 */
@Entity
@Table(name="REGIME_SAISONNIER")
@NamedQuery(name="RegimeSaisonnier.findAll", query="SELECT r FROM RegimeSaisonnier r")
public class RegimeSaisonnier extends Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	private String regimeSaisonnier;

	public RegimeSaisonnier() {
	}

	public RegimeSaisonnier(String libelle, Date debut,  Etat etat, Ouvrage ouvrage, String regimeSaisonnier) {
		super(libelle, debut, etat, ouvrage);
		this.regimeSaisonnier = regimeSaisonnier;
	}

	public String getRegimeSaisonnier() {
		return regimeSaisonnier;
	}

	public void setRegimeSaisonnier(String regimeSaisonnier) {
		this.regimeSaisonnier = regimeSaisonnier;
	}	

}