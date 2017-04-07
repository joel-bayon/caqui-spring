package fr.rte_france.caqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.rte_france.caqui.dao.RegroupementDao;
import fr.rte_france.caqui.entity.Regroupement;
import fr.rte_france.caqui.service.GererRegroupement;

@RestController
@RequestMapping("/regroupements")
public class RegroupementController {
	@Autowired
	GererRegroupement gererRegroupement;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, 
		           produces={MediaType.APPLICATION_JSON_VALUE})
	@Transactional
	public Regroupement getAdherent(@PathVariable Long id ) {
			System.out.println("/regroupements/"+id);
			Regroupement regroupement   =  gererRegroupement.getRegroupementWithEvenements(id);
			//System.out.println(regroupement);
			return regroupement;
			/*if(regroupement == null)
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(regroupement, HttpStatus.OK);*/
		}
}
