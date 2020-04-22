package Uvsq21923164.exo5_2;

import java.io.Serializable;

public class NumeroTelephone implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String telephone;
	
	
	public NumeroTelephone(String nom, String telephone) {
		this.nom = nom;
		this.telephone = telephone;
	}

	
	@Override
	public String toString() {
		return nom + " - " + telephone;
	}

	
	public String getNom() {
		return nom;
	}

	
	public String getTelephone() {
		return telephone;
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroTelephone other = (NumeroTelephone) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	
	
	
	
}
