package sessions;

import java.util.List;

import dao.FiliereIDAO;
import dao.IDao;
import dao.IdaoLocal;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Stateless
public class FiliereService implements IDao<Filiere>, FiliereIDAO{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@PermitAll
	public boolean create(Filiere o) {
		em.persist(o);
		return true;
	}

	@Override
	@PermitAll
	@Transactional
	public boolean update(Filiere o) {
		try {
	        em.merge(o);
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	@PermitAll
	public boolean delete(Filiere o) {
		em.remove(em.contains(o) ? o: em.merge(o));
		return true;
	}

	@Override
	@PermitAll
	public Filiere findById(int id) {
		return em.find(Filiere.class, id);
	}

	@Override
	@PermitAll
	public List<Filiere> findAll() {
		jakarta.persistence.Query query = em.createQuery("select f from Filiere f");
		return query.getResultList();		
	}

	@Override
	public List<Etudiant> findByFiliere(String name) {
		return null;
	}

	
	
	

}
