package org.eclipse.model.fab2;

public class GetPlanFactory {
	
	//	Un modèle de fabrique indique qu'il suffit de définir 
	//  une interface ou une classe abstraite pour créer un objet, mais de laisser les sous-classes 
	//  décider quelle classe instancier. En d'autres termes, les sous-classes sont chargées de créer 
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
