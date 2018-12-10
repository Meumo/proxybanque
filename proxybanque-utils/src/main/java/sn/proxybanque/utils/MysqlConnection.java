package sn.proxybanque.utils;
/**
 * Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les acces la base en une et une seule instance de
 * connection
 * @author DIOUF Mamadou
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Date Juillet 23-2018 # Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les acces a la base en une et une seule instance
 * de connection.
 * 
 * @author DIOUF Mamadou
 *
 */
public class MysqlConnection {
	private static Logger logger = Logger.getLogger("InfoLogging");
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
	private static String passworddDb = "proxibanque";
	/**
	 * l'unique instance de connexion a la base
	 */
	private static Connection conn = null;

	/**
	 * Constructeur prive pour blocquer la creation d'instance de la classe
	 */
	private MysqlConnection() {
		super();
	}

	/**
	 * Cette methode retourne l'unique instance de connection avec la base
	 * 
	 * @return conn retourne un objet de type connection
	 */
	public static Connection getInstanceConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, userDb, passworddDb);
				logger.info("\tConnexion etablie avec la base");
				logger.info("------------------------------------------------------------");
			}
		} catch (SQLException e) {
			logger.info("Probleme de connexion");
			e.printStackTrace();
		}
		return conn;
	}

}
