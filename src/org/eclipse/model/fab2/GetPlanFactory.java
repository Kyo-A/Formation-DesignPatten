package org.eclipse.model.fab2;

public class GetPlanFactory {
	
	//	Un mod�le de fabrique indique qu'il suffit de d�finir 
	//  une interface ou une classe abstraite pour cr�er un objet, mais de laisser les sous-classes 
	//  d�cider quelle classe instancier. En d'autres termes, les sous-classes sont charg�es de cr�er 
	//  l'instance de la classe.

	public Plan getPlan(String planType) {
		if (planType == null) {
			return null;
		}
		if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		} else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommercialPlan();
		} else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			return new InstitutionalPlan();
		}
		return null;
	}

}
