package Uvsq21923164.exo5_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcInitializer {
	
	private static final String userName = "ramdane";
	private static final String password = "youyou";
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String dburl = "jdbc:derby:lib;create=true";
	
	public JdbcInitializer() {
		Properties connectionProps = new Properties(); 
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}
/*  methode qui supprime la table s'il exit ensuit cree une nouvelle table */
	
	public void dropCreateTables() {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			
			Statement state = connect.createStatement();
			state.addBatch("DROP TABLE personnelGroupes");
			state.addBatch("DROP TABLE appartient");
			state.addBatch("DROP TABLE personnels");
			state.addBatch("CREATE TABLE personnelGroupes ("
					+ "id VARCHAR(100) PRIMARY KEY"
					+ ")");
			state.addBatch( // Association n-n
					"CREATE TABLE appartient ("
					+ "id VARCHAR(100),"
					+ "nom VARCHAR(100)"
					+ ")"); // Clés étrangères non définies

			state.addBatch(
					"CREATE TABLE personnels ("
					+ "nom VARCHAR(100) PRIMARY KEY,"
					+ "prenom VARCHAR(100) NOT NULL,"
					+ "fonction VARCHAR(100) NOT NULL"
					// + "date_NAISSANCE DATE"
					+ ")");
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
}
