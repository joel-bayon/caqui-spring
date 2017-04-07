package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the EVENEMENT database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="EcritureCahier.findAll", query="SELECT e FROM Evenement e")
abstract public class EcritureCahier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENEMENT_IDEVENEMENT_GENERATOR", sequenceName="SEQUENCE_PRINCIPAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENEMENT_IDEVENEMENT_GENERATOR")
	@Column(name="ID_EVENEMENT")
	protected long id;

	protected String archive;
	protected String cnes;
	protected String commentaire;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_DEBUT")
	protected Date debut = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_FIN")
	protected Date fin;

	protected String description;

	@Column(name="LIB_EVENEMENT")
	protected String libelle;

	@Column(name="VALIDATION_MCE")
	protected String validationMce;


	public EcritureCahier() {}
	
	public EcritureCahier(String libelle, Date debut) {
		if(debut != null ) this.debut = debut;
		this.libelle = libelle;
	
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArchive() {
		return this.archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public String getCnes() {
		return this.cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(Date dateDebut) {
		this.debut = dateDebut;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date dateFin) {
		this.fin = dateFin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getValidationMce() {
		return this.validationMce;
	}

	public void setValidationMce(String validationMce) {
		this.validationMce = validationMce;
	}

	

	@Override
	public String toString() {
		return "EcritureCahier [id=" + id + ", debut=" + debut + ", fin=" + fin + ", description=" + description
				+ ", libelle=" + libelle + "]";
	}


}