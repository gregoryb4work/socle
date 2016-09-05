package fr.gba.socle.generique.metaparameter.resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;
import fr.gba.socle.generique.metaparameter.dto.MetaParametersDto;

public interface MetaParameterResource {

	@RequestMapping(value = "/paramMetier/{cles}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public MetaParametersDto getParametresMetier(@PathVariable("cles") List<MetaParameterKey> cles,
			@RequestParam("sort") Boolean sort);

	@RequestMapping(value = "/paramMetier/{cle}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Boolean setParametresMetier(@PathVariable("cle") MetaParameterKey cle,
			@RequestParam("valeur") String valeur);

	// TODO PUT liste en body
	@RequestMapping(value = "/paramMetier", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Boolean setParametresMetier(@RequestBody MetaParametersDto paramsMetiersDto);
}
