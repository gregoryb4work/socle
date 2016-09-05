package fr.gba.socle.generique.metaparameter.domain;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MetaParameterKey implements Comparator<MetaParameterKey> {

	// TODO faire des sous types. CE type sert uniquement aux composantes => en
	// faire une sous type CleComposante. puis une chapeau qui inclut ce sous
	// type

	EXAMPLE_1("example1", "description example 1", "type1"), EXAMPLE_2("example2", "description example 2", "type2");

	private String name = "";

	private String description = "";

	private String type = "";

	private static final Logger logger = LoggerFactory.getLogger(MetaParameterKey.class);

	MetaParameterKey(String name, String description, String type) {
		this.name = name;
		this.type = type;
		this.description = description;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public static MetaParameterKey fromName(String name) {
		MetaParameterKey retour;
		retour = null;
		logger.debug("Conversion de la clé " + name);
		for (MetaParameterKey cleParametreMetier : MetaParameterKey.values()) {
			if (cleParametreMetier.getName().equals(name)) {
				retour = cleParametreMetier;
				break;
			}
		}
		if (retour == null) {
			throw new IllegalArgumentException("Cette valeur de cle de parametre  n'existe pas");
		}
		return retour;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(MetaParameterKey arg0, MetaParameterKey arg1) {
		return arg0.toString().compareTo(arg1.toString());

	}
}
