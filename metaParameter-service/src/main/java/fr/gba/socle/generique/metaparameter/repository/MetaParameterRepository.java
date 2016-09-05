package fr.gba.socle.generique.metaparameter.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;
import fr.gba.socle.generique.metaparameter.dto.MetaParameterDto;
import fr.gba.socle.generique.metaparameter.dto.MetaParametersDto;

/**
 * @author gbadaire
 *
 */
@Repository
public class MetaParameterRepository {
	// @Autowired
	// private JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MetaParameterRepository.class);

	/**
	 * @param paramMetierParams
	 * @return
	 */
	public MetaParametersDto getParametresMetier(List<MetaParameterKey> cles, Boolean sort) {
		MetaParametersDto retour;
		String valeur;
		List<MetaParameterDto> bouchonsBdd;
		retour = new MetaParametersDto();
		bouchonsBdd = null;

		// TODO lancer la récupération en base
		// DEBUT BOUCHONS
		logger.debug("CLes is null ? " + cles);
		if (cles != null) {
			bouchonsBdd = new ArrayList<MetaParameterDto>();

			for (MetaParameterKey cle : cles) {
				logger.debug(cle.toString());

				switch (cle) {
				case EXAMPLE_1:
					valeur = "713.881";
					break;
				case EXAMPLE_2:
					valeur = "344.281";
					break;
				default:
					valeur = "0";
				}
				bouchonsBdd.add(new MetaParameterDto(cle, valeur));
			}
		}
		// FIN BOUCHONS
		if (sort != null && sort) {
			Collections.sort(bouchonsBdd, new MetaParameterDto());
		}
		retour.addParamsMetier(bouchonsBdd);
		return retour;
	}

	/**
	 * @param cle
	 * @param valeur
	 * @return
	 */
	public Boolean setParametresMetier(MetaParameterKey cle, String valeur) {
		// TODO Auto-generated method stub
		logger.info("Modifie la valeur de la clé " + cle + " avec la valeur " + valeur);
		return Boolean.FALSE;
	}

	/**
	 * @param paramsMetiersDto
	 * @return
	 */
	public Boolean setParametresMetier(MetaParametersDto paramsMetiersDto) {
		// TODO Auto-generated method stub
		logger.info("Modifie les valeur des clés " + paramsMetiersDto.recupereListeParametresMetier().toString());
		return Boolean.FALSE;
	}

}
