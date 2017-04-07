package fr.rte_france.caqui.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the OUVRAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Ouvrage.findAll", query="SELECT o FROM Ouvrage o")
public class Ouvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OuvragePK id;

	private String bdc;

	@Column(name="LIB_OUVRAGE")
	private String libOuvrage;

	public Ouvrage() {
	}
	
	public Ouvrage(String libelle, OuvragePK pk) {
		libOuvrage = libelle;
		id   = pk;
	}

	public OuvragePK getId() {
		return this.id;
	}

	public void setId(OuvragePK id) {
		this.id = id;
	}

	public String getBdc() {
		return this.bdc;
	}

	public void setBdc(String bdc) {
		this.bdc = bdc;
	}

	public String getLibOuvrage() {
		return this.libOuvrage;
	}

	public void setLibOuvrage(String libOuvrage) {
		this.libOuvrage = libOuvrage;
	}

	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", bdc=" + bdc + ", libOuvrage=" + libOuvrage + "]";
	}
	
	

}