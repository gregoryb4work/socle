package fr.gba.socle.generique.metaparameter.resource.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import fr.gba.socle.generique.metaparameter.converter.MetaParameterKeyConverter;
import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;
import fr.gba.socle.generique.metaparameter.dto.MetaParametersDto;
import fr.gba.socle.generique.metaparameter.resource.MetaParameterResource;
import fr.gba.socle.generique.metaparameter.service.MetaParameterService;

@RestController
public class MetaParameterResourceImpl implements MetaParameterResource {

	private static final Logger logger = LoggerFactory.getLogger(MetaParameterResourceImpl.class);

	@Autowired
	private MetaParameterService paramMetierService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(MetaParameterKey.class, new MetaParameterKeyConverter());
	}

	// TODO implementer le sorting et le pretty ?
	@Override
	@HystrixCommand(
			// fallbackMethod = "getPAramMetierParDefaut",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") })
	public MetaParametersDto getParametresMetier(@PathVariable List<MetaParameterKey> cles, Boolean sort) {
		logger.debug("REQUETE getParametresMetier debut ");
		// var
		MetaParametersDto retour;
		// init
		retour = null;
		// traitement
		retour = paramMetierService.getParametresMetier(cles, sort);
		// retour
		logger.debug("REQUETE getParametresMetier fin");
		return retour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * paramMetier.domain.CleParametreMetier, java.lang.String)
	 */
	@Override
	@HystrixCommand(
			// fallbackMethod = "getPAramMetierParDefaut",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") })
	public Boolean setParametresMetier(@PathVariable MetaParameterKey cle, @RequestParam String valeur) {
		logger.debug("REQUETE setParametresMetier unitaire debut ");
		logger.info("cle = " + cle);
		Boolean retour = null;
		retour = paramMetierService.setParametresMetier(cle, valeur);
		logger.debug("REQUETE setParametresMetier unitaire fin ");
		return retour;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * paramMetier.dto.ParamsMetiersDto)
	 */
	@Override
	@HystrixCommand(
			// fallbackMethod = "getPAramMetierParDefaut",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000") })
	public Boolean setParametresMetier(@RequestBody MetaParametersDto paramsMetiersDto) {
		logger.debug("REQUETE setParametresMetier liste debut ");
		Boolean retour = null;
		retour = paramMetierService.setParametresMetier(paramsMetiersDto);
		logger.debug("REQUETE setParametresMetier liste fin ");
		return retour;
	}
}