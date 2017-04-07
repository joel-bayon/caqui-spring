package fr.rte_france.caqui.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.rte_france.caqui.dao.RegroupementDao;
import fr.rte_france.caqui.entity.Etat;
import fr.rte_france.caqui.entity.Evenement;
import fr.rte_france.caqui.entity.Regroupement;
import fr.rte_france.caqui.service.CaquiException;
import fr.rte_france.caqui.service.GererRegroupement;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GererRegroupementImpl implements GererRegroupement{
	 
	private int maxEvenement;
	
	@Autowired
	private RegroupementDao regroupementDao;

	@Autowired
	public GererRegroupementImpl(@Value("2")  int maxEvenement) {
		super();
		this.maxEvenement = maxEvenement;
	}
	
	public GererRegroupementImpl() {}

	public int getMaxEvenement() {
		return maxEvenement;
	}

	public void setMaxEvenement(int maxEvenement) {
		this.maxEvenement = maxEvenement;
	}
	
	@Override
	public Regroupement creerRegroupement(String type, String libelle, Date debut, List<Evenement> evenements) throws CaquiException {
		Regroupement regroupement = null;
		if(evenements == null || (evenements != null && evenements.size() <= maxEvenement)) {
			 regroupement = new Regroupement(type, libelle, debut, evenements);
			 return regroupementDao.save(regroupement);
		}
		throw new CaquiException("erreur : creation d'un regroupement avec un nombre trop élevé d'événements", null,null);
		
	}	
	
	@Override
	public void ajouterEvenement(long idRegroupement, Evenement evenement) throws CaquiException  {
		
		Regroupement regroupement = regroupementDao.findOne(idRegroupement);
		if(maxEvenement > regroupement.getEvenements().size()) {
			
			regroupement.addEvenement(evenement);
			regroupementDao.save(regroupement);
			return;
		}
		throw new CaquiException("nb evenements = maxEvenement du regroupement", regroupement, evenement);
	}
	
	@Override
	public void cloturerRegroupement(long idRegroupement) {
		
		Regroupement regroupement = regroupementDao.findOne(idRegroupement);
		for(Evenement even : regroupement.getEvenements()) {
			if(even.getEtat() != Etat.CLOS) {
				even.setEtat(Etat.CLOS);
				even.setFin(new Date());
			}
		}
		regroupement.setFin(new Date());
		regroupementDao.save(regroupement);
	}

	
}
