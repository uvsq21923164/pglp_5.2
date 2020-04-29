package Uvsq21923164.exo5_2;

import java.io.Serializable;

public abstract class SerialDAO<T extends Serializable>	extends Serializer<T> 
													implements DAO<T> {
	
	
	
	public abstract String getFilename(String id);	
	public abstract String getFilename(T obj);
	
	@Override
	public T create(T obj) {
		return createFile(obj, getFilename(obj));
	}

	@Override
	public T read(String id) {
		return readFile(getFilename(id));
	}

	@Override
	public T update(T obj) {
		return updateFile(obj, getFilename(obj));
	}

	@Override
	public void delete(T obj) {
		deleteFile(getFilename(obj));
	}
}
