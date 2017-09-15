package blowmind.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import blowmind.Entity.Recruit;

@Repository
@Transactional
public class RecruitDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Recruit recruit) {

		entityManager.persist(recruit);
		
		return;

	}
	
	@SuppressWarnings("unchecked")
	public List<Recruit> getAll() {

		return entityManager.createQuery("from Recruit").getResultList();
		

	}
	
	public Recruit getByID(long recruidID ) {

		Query got = entityManager.createQuery("from Recruit where id = :recruidID");
		got.setParameter("recruidID", recruidID);
		
		try {
			
			Recruit recruit = (Recruit) got.getSingleResult();
			return recruit;
		} catch (Exception ex) {
			return null;
		}
		

	}

}
