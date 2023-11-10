package dao;

import java.util.List;

import entities.Etudiant;
import jakarta.ejb.Local;

@Local
public interface IdaoLocal<T> {
	boolean create(T o);
	boolean update(T o);
	boolean delete(T o);
	T findById(int id);
	List<T> findAll();
	List<Etudiant> findByFiliere(String name);
}
