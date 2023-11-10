package sessions;

import java.util.List;

import dao.EtudiantIDAO;
import dao.IDao;
import dao.IdaoLocal;
import entities.Employe;
import entities.Etudiant;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



@Stateless
public class EtudiantService implements IDao<Etudiant>, EtudiantIDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@PermitAll
	public boolean create(Etudiant o) {
		em.persist(o);
		return true;
	}

	@Override
	@PermitAll
	public boolean update(Etudiant o) {
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
	public boolean delete(Etudiant o) {
		em.remove(em.contains(o) ? o: em.merge(o));
		return true;
	}

	@Override
	@PermitAll
	public Etudiant findById(int id) {
		return em.find(Etudiant.class, id);
	}

	@Override
	@PermitAll
	public List<Etudiant> findAll() {
		jakarta.persistence.Query query = em.createQuery("select e from Etudiant e");
		return query.getResultList();		
	}
	

	@Override
	@PermitAll
	public List<Etudiant> findByFiliere(String name) {
		
		List<Etudiant> individus = null;
		individus = em
		              .createQuery("select e from Etudiant e where e.filiere.name = ?1", Etudiant.class)
		              .setParameter(1, name)
		              .getResultList();
		return individus;
	}
	
	

}
