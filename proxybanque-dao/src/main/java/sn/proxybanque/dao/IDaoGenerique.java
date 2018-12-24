package sn.proxybanque.dao;

import java.util.List;

/**
 * Date Decembre 18-2018 # L'interface IDaoGenerique c'est une interface
 * generique qui contient nos methodes generique.
 * 
 * @author DIOUF Mamadou & DIACK Mamadou
 *
 * @param <T>
 *            Parametre de type generique
 */
public interface IDaoGenerique<T> {
	/**
	 * La methode 'create(T t)' generique a pour but de recevoir un objet et de
	 * l'ajouer dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void create(T t);

	/**
	 * La methode 'update()' generique a pour but de mettre a jour les donnees d'une
	 * ligne precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void update(T t);

	/**
	 * La methode 'read()' generique a pour but lire des donnees dans une base de
	 * donnees relationnelle, creer une liste et l'ajouter dans cette derniere.
	 * 
	 * @return List (retourne une liste d'objet)
	 */
	public List<T> read();

	/**
	 * La methode 'delete(T t)' generique a pour but de supprimer les donnees d'une
	 * ligne precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void delete(T t);

	/**
	 * La methode 'display(T t)' generique a pour but de consulter les donnees d'une
	 * table precise dans une base de donnees relationnelle.
	 * 
	 * @param t
	 *            Parametre de type generique
	 */
	public void display(T t);

}
