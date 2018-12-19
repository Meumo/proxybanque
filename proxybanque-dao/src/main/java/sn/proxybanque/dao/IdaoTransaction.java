package sn.proxybanque.dao;

import sn.proxybanque.domaine.Compte;

public class IdaoTransaction {

	public void verser(Compte compte, float montcred) {
		double ancienSolde = compte.getSoldeCompte();
		double nouvoSolde = ancienSolde + montcred;
		compte.setSoldeCompte(nouvoSolde);
		System.out.println("Operation reussie! Nouveau solde:" + nouvoSolde);
	}

	public boolean retirer(Compte compte, float montdb) {
		boolean result = false;
		if (compte.getSoldeCompte() > montdb) {

			double ancienSolde = compte.getSoldeCompte();
			double nouvoSolde = ancienSolde - montdb;
			compte.setSoldeCompte(nouvoSolde);
			System.out.println("Operation reussie! Nouveau solde:" + nouvoSolde);
			result = true;
			System.out.println("-----------------");
		} else {
			System.out.println("impossible!! Montant a debiter supperieur au solde");
		}
		return result;
	}

	public void virer(Compte compteDebiteur, Compte compteCrediteur, float montant) {
		boolean isCorrect = this.retirer(compteDebiteur, montant);
		if (isCorrect) {
			this.verser(compteCrediteur, montant);
			System.out.println("Operation de virement reussie!!");
		} else {
			System.out.println("Operation Impossible!!");
		}
	}
}
