package Uvsq21923164.exo5_2;

import Uvsq21923164.exo5_2.AbstractDAOFactory.DAOType;
import Uvsq21923164.exo5_2.Personnel.PersonnelBuilder;

public enum Serialization {
	ENVIRONNEMENT;
	
	private void run(String[] args, DAOType dt) {
		DAO<Personnel> personnelDAO = AbstractDAOFactory
				.getFactory(dt) // Factory
				.getPersonnelDAO();
		DAO<PersonnelGroupe> pgDAO = AbstractDAOFactory
				.getFactory(dt)
				.getPersonnelGroupeDAO();
		// Creation personnel
		Personnel d = new PersonnelBuilder("youyou", "youcef", "Employé")
				   			.build();
		Personnel p = new PersonnelBuilder("bachir", "skakni", "Employé")
							.build();
		PersonnelGroupe pg = new PersonnelGroupe();
		PersonnelGroupe spg = new PersonnelGroupe();
		pg.addPersonnel(spg);
		pg.addPersonnel(p);
		spg.addPersonnel(d);
		// Ajout DAO
		pgDAO.create(pg);
		pgDAO.create(spg);
		personnelDAO.create(d); // update
		personnelDAO.create(p); // update
		System.out.println("\t" + pgDAO.read(spg.getId()));
		System.out.println("\t" + personnelDAO.read("p"));
	}
	
	public static void main(String[] args) {
		JdbcInitializer jinit = new JdbcInitializer();
		jinit.dropCreateTables(); 
		ENVIRONNEMENT.run(args, DAOType.JDBC);
	}
}
