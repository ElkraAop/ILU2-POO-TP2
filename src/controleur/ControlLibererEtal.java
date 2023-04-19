package controleur;

import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}


		public boolean isVendeur(String nomVendeur) {
			return(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null);
		}


	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = null;
		donneesEtal = this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
		this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).libererEtal();
		return donneesEtal;
	}
}
