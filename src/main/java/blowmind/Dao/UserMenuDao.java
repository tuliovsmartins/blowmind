package blowmind.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import blowmind.Converter.UserMenuConverter;
import blowmind.Entity.UserMenu;

@Repository
@Transactional
public class UserMenuDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserMenuConverter userMenuConverter;
	
	public void create(UserMenu userMenu) {

		entityManager.persist(userMenuConverter.convert(userMenu));
		return;

	}
	
	public void update(UserMenu userMenu) {
		entityManager.merge(userMenuConverter.convert(userMenu));
		return;
	}

	@SuppressWarnings("unchecked")
	public List<UserMenu> getAll() {
		return entityManager.createQuery("from UserMenu").getResultList();
	}
	
	
	public UserMenu getById(long id) {
		return entityManager.find(UserMenu.class, id);
	}
	

}
