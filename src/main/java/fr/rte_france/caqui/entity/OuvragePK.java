package fr.rte_france.caqui.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the OUVRAGE database table.
 * 
 */
@Embeddable
public class OuvragePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_OUVRAGE")
	private String idOuvrage;

	@Column(name="TYPE_OUVRAGE")
	private String typeOuvrage;

	public OuvragePK() {}
	
	public OuvragePK(String idOuvrage, String typeOuvrage) {
		this.idOuvrage = idOuvrage;
		this.typeOuvrage = typeOuvrage;
	}
	
	public String getIdOuvrage() {
		return this.idOuvrage;
	}
	public void setIdOuvrage(String idOuvrage) {
		this.idOuvrage = idOuvrage;
	}
	public String getTypeOuvrage() {
		return this.typeOuvrage;
	}
	public void setTypeOuvrage(String typeOuvrage) {
		this.typeOuvrage = typeOuvrage;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OuvragePK)) {
			return false;
		}
		OuvragePK castOther = (OuvragePK)other;
		return 
			this.idOuvrage.equals(castOther.idOuvrage)
			&& this.typeOuvrage.equals(castOther.typeOuvrage);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOuvrage.hashCode();
		hash = hash * prime + this.typeOuvrage.hashCode();
		
		return hash;
	}

	@Override
	public String toString() {
		return "OuvragePK [idOuvrage=" + idOuvrage + ", typeOuvrage=" + typeOuvrage + "]";
	}
	
	
}