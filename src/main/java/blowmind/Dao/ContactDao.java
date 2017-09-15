package blowmind.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import blowmind.Entity.Contact;

@Repository
@Transactional
public class ContactDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(Contact contact) {

		entityManager.persist(contact);
		
		return;

	}

}
