package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the MODE_DEGRADE database table.
 * 
 */
@Entity
@Table(name="MODE_DEGRADE")
@NamedQuery(name="ModeDegrade.findAll", query="SELECT m FROM ModeDegrade m")
public class ModeDegrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODE_DEGRADE_IDREGROUPEMENT_GENERATOR", sequenceName="SEQUENCE_PRINCIPAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODE_DEGRADE_IDREGROUPEMENT_GENERATOR")
	@Column(name="ID_REGROUPEMENT")
	private long idRegroupement;

	@Column(name="ANALYSE_RISQUE")
	private String analyseRisque;

	@Column(name="COMMENTAIRE_CNES")
	private String commentaireCnes;

	@Column(name="IMPACT_QDE")
	private String impactQde;

	@Column(name="IMPACT_SURETE")
	private String impactSurete;

	private BigDecimal indice;

	@Column(name="MATERIEL_CLIENT")
	private String materielClient;

	@Column(name="NUMERO_MD")
	private String numeroMd;

	private String ouvrage;

	@Column(name="SUITE_MEC")
	private String suiteMec;

	@Column(name="ZONE_PMR")
	private String zonePmr;

	@Column(name="ZONE_QDE_PRIORISE")
	private String zoneQdePriorise;

	//uni-directional one-to-one association to Regroupement
	@OneToOne
	@JoinColumn(name="ID_REGROUPEMENT")
	private Regroupement regroupement;

	public ModeDegrade() {
	}

	public long getIdRegroupement() {
		return this.idRegroupement;
	}

	public void setIdRegroupement(long idRegroupement) {
		this.idRegroupement = idRegroupement;
	}

	public String getAnalyseRisque() {
		return this.analyseRisque;
	}

	public void setAnalyseRisque(String analyseRisque) {
		this.analyseRisque = analyseRisque;
	}

	public String getCommentaireCnes() {
		return this.commentaireCnes;
	}

	public void setCommentaireCnes(String commentaireCnes) {
		this.commentaireCnes = commentaireCnes;
	}

	public String getImpactQde() {
		return this.impactQde;
	}

	public void setImpactQde(String impactQde) {
		this.impactQde = impactQde;
	}

	public String getImpactSurete() {
		return this.impactSurete;
	}

	public void setImpactSurete(String impactSurete) {
		this.impactSurete = impactSurete;
	}

	public BigDecimal getIndice() {
		return this.indice;
	}

	public void setIndice(BigDecimal indice) {
		this.indice = indice;
	}

	public String getMaterielClient() {
		return this.materielClient;
	}

	public void setMaterielClient(String materielClient) {
		this.materielClient = materielClient;
	}

	public String getNumeroMd() {
		return this.numeroMd;
	}

	public void setNumeroMd(String numeroMd) {
		this.numeroMd = numeroMd;
	}

	public String getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(String ouvrage) {
		this.ouvrage = ouvrage;
	}

	public String getSuiteMec() {
		return this.suiteMec;
	}

	public void setSuiteMec(String suiteMec) {
		this.suiteMec = suiteMec;
	}

	public String getZonePmr() {
		return this.zonePmr;
	}

	public void setZonePmr(String zonePmr) {
		this.zonePmr = zonePmr;
	}

	public String getZoneQdePriorise() {
		return this.zoneQdePriorise;
	}

	public void setZoneQdePriorise(String zoneQdePriorise) {
		this.zoneQdePriorise = zoneQdePriorise;
	}

	public Regroupement getRegroupement() {
		return this.regroupement;
	}

	public void setRegroupement(Regroupement regroupement) {
		this.regroupement = regroupement;
	}

}