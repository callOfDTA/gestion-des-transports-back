package dev.entite;

public enum CategorieVehicule {

	MICRO_URBAINE("Micro-urbaines"), MINI_CITADINE("Mini-citadines"), CITADINE_POLYVALENTE(
			"Citadines polyvalentes"), COMPACTES("Compactes"), BERLINE_S("Berlines Taille S"), BERLINE_M(
					"Berlines Taille M"), BERLINE_L("Berlines Taille L"), SUV("SUV, Tout-terrains et Pick-up");

	private String value;

	private CategorieVehicule(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
