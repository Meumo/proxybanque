//package sn.proxybanque.utils;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Properties;
//
///**
// * * Cette classe met en oeuvre le design pattern singleton elle permet de
// * restreindre les accés a la base en une et une seule instance de connection
// * 
// * @author jack
// * @since 05.08.2018
// * @version 1.2-SNAPSOT
// */
//
//public class MaConnection {
//	private static Connection connection;
//
//	public static Connection getConnectionDB() {
//		if (connection == null) {
//
//			try {
////				// Création d'une instance de la classe Properties
////				Properties prop = new Properties();
////				// Etablissement de la communication entre le programme et le fichier
////
////				InputStream input = new FileInputStream("config.properties");
////				// Chargement du fichier dans l'objet prop
////				prop.load(input);
////				// Propriétés du fichier et récupération des valeurs des clés
////				String driver = prop.getProperty("driver");
////				String url = prop.getProperty("url");
////				String login = prop.getProperty("user");
////				String pwd = prop.getProperty("password");
////				// Chargement du driver
////				//Class.forName(driver).newInstance();
////				// Création de la connection avec la base de données
//				connection = DriverManager.getConnection(url, login, pwd);
//
//				System.out.println("Connection Etabli");
//			} catch (Exception e) {
//				System.out.println("Erreur execution Mysql!");
//			} finally {
//
//			}
//		}
//
//		return connection;
//	}
//
//}
