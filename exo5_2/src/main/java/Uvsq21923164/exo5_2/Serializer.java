package Uvsq21923164.exo5_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Serializer<T extends Serializable> {
	
	public T writeFile(T obj, String filename) {
		try (ObjectOutputStream	out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(filename)))) {
			out.writeObject(obj);
			System.out.println(("Objet " + obj + " créé!")); 
			return obj;
		} catch (IOException e) {
		System.out.println(e.getMessage());	
			return null;
		}
	}
	
	public void deleteFile(String filename) {
		File file = new File(filename); 
        if(file.delete())
        	System.out.println("Objet supprimé!"); 
        else System.out.println("Suppression impossible");
	}
	
	private boolean exists(String filename) {
		File file = new File(filename); 
        return file.exists();
	}
	
	public T readFile(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(filename)))) {
			T obj = (T) in.readObject();
			System.out.println("Objet " + obj + " lu!");
			return obj;
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public T createFile(T obj, String filename) {
		if (exists(filename)) {
			System.out.println("Création impossible");
			return null;
		}
		else {
			writeFile(obj, filename);
			return obj;
		}
	}
	
	public T updateFile(T obj, String filename) {
		if (!exists(filename)) {
			System.out.println("Mise à jour impossible");
			return null;
		}
		else {
			deleteFile(filename);
			writeFile(obj, filename);
			return obj;
		}
	}

}
