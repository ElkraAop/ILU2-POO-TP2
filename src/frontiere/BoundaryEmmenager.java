package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("bienvenu Villageois "+nomVisiteur);
					int ForceUtilisateur = Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, ForceUtilisateur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("bienvenu Druide "+nomVisiteur);
		int ForceUtilisateur = Clavier.entrerEntier("Quelle est votre force ?");
		int effetPMin = 1;
		int effetPMax = 0;
		while(effetPMin>=effetPMax) {
			effetPMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetPMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");
			if(effetPMin>=effetPMax) {
				System.out.println("Attention Druide , vous vous �tes tromp� dans le min et max");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, ForceUtilisateur,effetPMin,effetPMax);
	}
}
