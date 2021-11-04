package org.eclipse.model.builder2;

//Le modèle Builder a été introduit pour résoudre certains des problèmes 
//liés aux modèles de conception Factory et Abstract Factory 
//lorsque l'objet contient de nombreux attributs.
//Il y a trois problèmes majeurs avec les modèles de conception Factory et Abstract Factory 
//lorsque l'objet contient beaucoup d'attributs.

//Trop d'arguments à transmettre du programme client à la classe Factory qui peuvent 
//être sujets aux erreurs car la plupart du temps, le type d'arguments est le même et du côté client, 
//il est difficile de maintenir l'ordre des arguments.
//Certains des paramètres peuvent être facultatifs, mais dans le modèle d'usine, 
//nous sommes obligés d'envoyer tous les paramètres et les paramètres facultatifs 
//doivent être envoyés en tant que NULL.
//Si l'objet est lourd et que sa création est complexe, alors toute cette complexité fera partie des classes Factory qui prête à confusion.
public class CDBuilder {
	
	public CDType buildSonyCD() {
		CDType cds = new CDType();
		cds.addItem(new Sony());
		return cds;
	}

	public CDType buildSamsungCD() {
		CDType cds = new CDType();
		cds.addItem(new Samsung());
		return cds;
	}
}
