
package fr.gba.socle.generique.metaparameter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;
import fr.gba.socle.generique.metaparameter.dto.MetaParametersDto;
import fr.gba.socle.generique.metaparameter.repository.MetaParameterRepository;

/**
 * @author gbadaire
 *
 */
@Service
public class MetaParameterService {

	@Autowired
	private MetaParameterRepository paramMetierRepository;

	/**
	 * @param paramMetierParams
	 * @return
	 */
	public MetaParametersDto getParametresMetier(List<MetaParameterKey> cles, Boolean sort) {
		MetaParametersDto paramsMetier;
		paramsMetier = paramMetierRepository.getParametresMetier(cles, sort);
		return paramsMetier;
	}

	/**
	 * @param cle
	 * @param valeur
	 * @return
	 */
	public Boolean setParametresMetier(MetaParameterKey cle, String valeur) {
		Boolean retour = null;
		retour = paramMetierRepository.setParametresMetier(cle, valeur);
		return retour;
	}

	/**
	 * @param paramsMetiersDto
	 * @return
	 */
	public Boolean setParametresMetier(MetaParametersDto paramsMetiersDto) {
		Boolean retour = null;
		retour = paramMetierRepository.setParametresMetier(paramsMetiersDto);
		return retour;
	}

}
