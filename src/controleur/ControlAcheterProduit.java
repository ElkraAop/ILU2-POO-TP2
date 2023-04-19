package controleur;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverProduit(String produit) {
		Gaulois[] listeEtals = village.rechercherVendeursProduit(produit);
		if(listeEtals == null) {
			return null;
		}else {
			String [] listeVendeurs = new String[listeEtals.length];
			for(int i=0;i<listeEtals.length;i++) {
				listeVendeurs[i] = listeEtals[i].getNom();
			}
		
			return listeVendeurs;
		}
	}
		
	public boolean verifierId(String MecCheum) {
		return controlVerifierIdentite.verifierIdentite(MecCheum);
	}
	public String acheterProduit(int Produit,String NomVendeur) {
		String resultat;
		int NbFleursAcheter = controlTrouverEtalVendeur.trouverEtalVendeur(NomVendeur).acheterProduit(Produit);
		if(NbFleursAcheter<Produit) {
			resultat = "vous avez acheter "+ NbFleursAcheter +" Vous avez vider l'étable ";
		}else {
			resultat = "vous avez acheter tout ce dont vous aviez besoin a " + NomVendeur;
		}
		return resultat;
	}
}
