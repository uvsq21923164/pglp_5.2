package Uvsq21923164.exo5_2;

public class PersonnelSerialDAO extends SerialDAO<Personnel> {

	public String getFilename(String id) {
		return id + ".personnel";
	}
	
	public String getFilename(Personnel obj) {
		return getFilename(obj.getNom());
	}

}
