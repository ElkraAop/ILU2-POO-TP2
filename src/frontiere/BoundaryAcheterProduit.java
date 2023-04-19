package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierId(nomAcheteur)) {
			System.out.println("nous ne vendons pas au inconu");
		}else {
			System.out.println("que voulez vous acheter ?");
			String Produit = scan.next();
			String[] tabVendeurs = controlAcheterProduit.trouverProduit(Produit);
			if (tabVendeurs==null) {
				System.out.println("personne ne vend ca sur le marché aujrd");
			}else {
				System.out.println("a qui voulez vous acheter : ");
				for(int i=0 ; i<tabVendeurs.length;i++) {
					System.out.println(i+"- "+tabVendeurs[i]);
				}
				int Vendeur = -1;
				while (Vendeur<0 || Vendeur>tabVendeurs.length) {
					Vendeur= scan.nextInt();	
					if (Vendeur<0 || Vendeur>tabVendeurs.length)
						System.out.println("entrez un nb valide");
				}
				System.out.println(nomAcheteur+" se deplace vers "+tabVendeurs[Vendeur]);
				System.out.println("combien de fleur voulez vous acheter ? ");
				int nBProduits = scan.nextInt();
				System.out.println(controlAcheterProduit.acheterProduit(nBProduits, tabVendeurs[Vendeur]));
			}
			
		}
		
	}
}
