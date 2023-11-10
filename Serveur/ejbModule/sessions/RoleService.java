package sessions;

import java.util.List;

import dao.IDao;
import dao.IdaoLocal;
import dao.RoleIDAO;
import entities.Employe;
import entities.Etudiant;
import entities.Filiere;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class RoleService implements IDao<Role>, RoleIDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@PermitAll
	public boolean create(Role o) {
		em.persist(o);
		return true;
	}

	@Override
	@PermitAll
	public boolean update(Role o) {
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
	public boolean delete(Role o) {
		em.remove(em.contains(o) ? o: em.merge(o));
		return true;
	}

	@Override
	@PermitAll
	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
		
		jakarta.persistence.Query query = em.createQuery("select r from Role r");
		return query.getResultList();		
	}

	@Override
	public List<Etudiant> findByFiliere(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
