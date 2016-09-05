/**
 * 
 */
package fr.gba.socle.generique.metaparameter.dto;

import java.util.Comparator;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;

/**
 * 
 * Ce pojo comprend le type de la valeur pour permettre au service de valider les données et si nécessaire aussi pour la
 * validation IHMs
 * 
 * @author gbadaire
 *
 */
public class MetaParameterDto implements Comparator<MetaParameterDto> {

	private MetaParameterKey cle;

	private String valeur;

	/**
	 * 
	 */
	public MetaParameterDto() {

	}

	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * @param cle
	 * @param valeur
	 * @param type
	 */
	public MetaParameterDto(MetaParameterKey cle, String valeur) {
		super();
		this.cle = cle;
		this.valeur = valeur;
	}

	/**
	 * @param valeur
	 *            the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the cle
	 */
	public MetaParameterKey getCle() {
		return cle;
	}

	/**
	 * @param cle
	 *            the cle to set
	 */
	public void setCle(MetaParameterKey cle) {
		this.cle = cle;
	}

	/**
	 * @param cle
	 *            the cle to set
	 */
	// TODO a prendre en compte pour le mapping ORM
	public void convertCle(String cle) {
		this.cle = MetaParameterKey.fromName(cle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(MetaParameterDto arg0, MetaParameterDto arg1) {
		return arg1.getCle().compare(arg0.getCle(), arg1.getCle());
	}

}
