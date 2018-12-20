package sn.proxybanque.service;

import java.util.List;

/**
 * Date Decembre 20-2018 # L'interface IServiceGenerique c'est une interface
 * generique qui contient nos methodes generique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 *
 * @param <T>
 *            Parametre de type generique
 */
public interface IServiceGenerique<T> {
	/**
	 * La methode 'ajouter(T t)' generique a pour but de recevoir un objet et de
	 * l'ajouer dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void ajouter(T t);

	/**
	 * La methode 'misAJour(T t)' generique a pour but de mettre a jour les donnees
	 * d'une ligne precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void misAJour(T t);

	/**
	 * La methode 'lister()' generique a pour but lister des donnees dans une base
	 * de donnees relationnelle, creer une liste et l'ajouter dans cette derniere.
	 * 
	 * @return List (retourne une liste d'objet)
	 */
	public List<T> lister();

	/**
	 * La methode 'supprimer(T t)' generique a pour but de supprimer les donnees
	 * d'une ligne precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void supprimer(T t);

	/**
	 * La methode 'consulter(T t)' generique a pour but de consulter les donnees
	 * d'une table precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void Consulter(T t);

}
