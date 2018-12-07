package sn.proxybanque.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * * Cette classe met en oeuvre le design pattern singleton elle permet de
 *   restreindre les accés a la base en une et une seule instance de connection
 * 
 * @author jack
 * @since 05.08.2018
 * @version 1.2-SNAPSOT
 */

public class MaConnection {

	/**
	 * url pour acceder a la base de donnees
	 */

	private static String url = "jdbc:mysql://localhost/proxibanque?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	/**
	 * Le nom d'utilisateur de la base de donnees
	 */
	private static String userDb = "proxibanque";
	/**
	 * Le mot de passe de la base de donnees
	 */
	private static String pwdDb = "proxibanque";
	/**
	 * l'unique instance de connexion a la base
	 */
	private static Connection conn = null;

	/**
	 * Constructeur prive pour bloquer la creation d'instance de la classe
	 */
	private MaConnection() {
		super();
	}

	/**
	 * Cette methode retourne l'unique instance de connection avec la base
	 * 
	 * @return conn retourne un objet de type connection
	 */
	public static Connection getInstanceConnection() {
		Logger logger = Logger.getLogger("InfoLogging");
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, userDb, pwdDb);
				logger.info("Connexion etablie avec la base");
			}
		} catch (SQLException e) {
			logger.info("Probleme de connexion");

		}
		return conn;
	}

}
