package Uvsq21923164.exo5_2;

public abstract class AbstractDAOFactory {
	
public enum DAOType { Serial};
	
	public abstract DAO<Personnel> getPersonnelDAO();
	
	public abstract DAO<PersonnelGroupe> getPersonnelGroupeDAO();
	
	public static AbstractDAOFactory getFactory(DAOType type) {
		
		if (type == DAOType.Serial) return new DAOFactory();
		return null;
	}

}
