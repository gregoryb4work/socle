/**
 * 
 */
package fr.gba.socle.generique.metaparameter.converter;

import java.beans.PropertyEditorSupport;

import fr.gba.socle.generique.metaparameter.domain.MetaParameterKey;

/**
 * @author gbadaire
 *
 */
public class MetaParameterKeyConverter extends PropertyEditorSupport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyEditor#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String arg) throws IllegalArgumentException {
		setValue(MetaParameterKey.fromName(arg));

	}

}
