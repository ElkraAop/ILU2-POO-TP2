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
			System.out.println("je suis d�sol�e "+ nomVendeur + "Mais il faut �tre un habitant pour commercer dans notre village");
		}else {
			System.out.println("bjr "+ nomVendeur+" je vais regarder si je peut te trouver un �tal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("d�sol�e "+nomVendeur+"je n'ai plus d'�tals qui ne soit pas occup�e");
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
			System.out.println("le vendeur "+ nomVendeur+"s'est install� � l'�tal n�"+ numEtal);
		}
		
	}
}
