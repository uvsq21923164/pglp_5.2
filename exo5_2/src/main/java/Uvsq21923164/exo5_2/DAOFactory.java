package Uvsq21923164.exo5_2;

public class DAOFactory  {
	
	public DAO<Personnel> getPersonnelDAO() {
		return new PersonnelSerialDAO();
	}
	
	public DAO<PersonnelGroupe> getPersonnelGroupeDAO() {
		return new PersonnelGroupeSerialDAO();
	}
	
}
