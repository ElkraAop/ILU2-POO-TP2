package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis désolée "+ nomVendeur + "Mais il faut être un habitant pour commercer dans notre village");
		}else {
			System.out.println("bjr "+ nomVendeur+" je vais regarder si je peut te trouver un étal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("désolée "+nomVendeur+"je n'ai plus d'étals qui ne soit pas occupée");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait il me reste un etal pour vous\n");
		System.out.println("il me faudrais des renseignements\n");
		System.out.println("Que shouaitez vous vendre ?\n");
		String produit = scan.next();
		int nbProduits = Clavier.entrerEntier("Combien en avez vous ?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduits);
		if(numEtal != -1) {
			System.out.println("le vendeur "+ nomVendeur+"s'est installé à l'étal n°"+ numEtal);
		}
		
	}
}
