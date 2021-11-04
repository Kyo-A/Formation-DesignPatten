package org.eclipse.model.builder2;

//Le mod�le Builder a �t� introduit pour r�soudre certains des probl�mes 
//li�s aux mod�les de conception Factory et Abstract Factory 
//lorsque l'objet contient de nombreux attributs.
//Il y a trois probl�mes majeurs avec les mod�les de conception Factory et Abstract Factory 
//lorsque l'objet contient beaucoup d'attributs.

//Trop d'arguments � transmettre du programme client � la classe Factory qui peuvent 
//�tre sujets aux erreurs car la plupart du temps, le type d'arguments est le m�me et du c�t� client, 
//il est difficile de maintenir l'ordre des arguments.
//Certains des param�tres peuvent �tre facultatifs, mais dans le mod�le d'usine, 
//nous sommes oblig�s d'envoyer tous les param�tres et les param�tres facultatifs 
//doivent �tre envoy�s en tant que NULL.
//Si l'objet est lourd et que sa cr�ation est complexe, alors toute cette complexit� fera partie des classes Factory qui pr�te � confusion.
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
