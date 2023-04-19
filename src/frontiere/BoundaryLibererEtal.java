package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'etes pas inscrits sur notre marché aujrd");
		}else {
			String[] data = controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu "+data[4]+" sur "+data[3]+data[2]
					+ "En revoir "+data[1]+", passez une bonne\r\n"
					+ "journée.");
		}
	}

}
