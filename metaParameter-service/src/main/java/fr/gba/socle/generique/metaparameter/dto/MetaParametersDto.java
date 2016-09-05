package fr.gba.socle.generique.metaparameter.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;

public class MetaParametersDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4643253890444762334L;

	private Map<MetaParameterKey, MetaParameterDto> paramsMetier;

	/**
	 * 
	 */
	public MetaParametersDto() {
		super();
		paramsMetier = new HashMap<MetaParameterKey, MetaParameterDto>();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public void add(MetaParameterDto arg0) {
		paramsMetier.put(arg0.getCle(), arg0);
	}

	/**
	 * @return the paramsMetier
	 */
	public List<MetaParameterDto> recupereListeParametresMetier() {
		return new ArrayList<MetaParameterDto>(paramsMetier.values());
	}

	/**
	 * @param paramsMetier
	 *            the paramsMetier to set
	 */
	public void addParamsMetier(Collection<MetaParameterDto> paramsMetier) {
		for (MetaParameterDto paramMetier : paramsMetier) {
			this.paramsMetier.put(paramMetier.getCle(), paramMetier);
		}
	}

	/**
	 * @param paramsMetier
	 *            the paramsMetier to set
	 */
	public void setParamsMetier(Map<MetaParameterKey, MetaParameterDto> paramsMetier) {
		this.paramsMetier = paramsMetier;
	}

	/**
	 * @return the paramsMetier
	 */
	public Map<MetaParameterKey, MetaParameterDto> getParamsMetier() {
		return paramsMetier;
	}
}
