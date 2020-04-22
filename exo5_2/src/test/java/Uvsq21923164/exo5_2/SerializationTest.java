package Uvsq21923164.exo51;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;



public class SerializationTest {

	private Personnel p;
	private PersonnelGroupe pg;
	
	@Before()
	public void setUp() {
		p = new Personnel.PersonnelBuilder("youyou", "joseph", "Plombier")
				.dateNaissance(LocalDate.parse("1998-01-06", DateTimeFormatter.ISO_DATE))
				.addNumeroTelephone(new NumeroTelephone("Perso", "0751393363"))
				.addNumeroTelephone(new NumeroTelephone("Fax", "0912315478")).build();
		
		pg = new PersonnelGroupe();
		PersonnelGroupe qg = new PersonnelGroupe();
		pg.addPersonnel(qg);
		pg.addPersonnel(p);
	}
	
	@Test()
	public void testSerializationPersonnel() {
		Personnel q = null;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("serial.txt"));
			ois = new ObjectInputStream(new FileInputStream("serial.txt"));
			
			try {
				oos.writeObject(p);
				q = (Personnel) ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} finally {
				oos.close();
				ois.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(p, q);
	}
	
	@Test()
	public void testSerializationPersonnelGroupe() {
		PersonnelGroupe qg = null;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("serial.txt"));
			ois = new ObjectInputStream(new FileInputStream("serial.txt"));
			
			try {
				oos.writeObject(pg);
				qg = (PersonnelGroupe) ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} finally {
				oos.close();
				ois.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(pg, qg);
	}
	
	
	
	
	
	
	
	
}

