package dao;

public interface DAO <T> {
	
	T create(T obj);
	T read(String id);
	T update(T obj);
	void delete(T obj);

}
