package blowmind.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import blowmind.Entity.MainMenu;

@Repository
@Transactional
public class MainMenuDao {
	
	@PersistenceContext
	private EntityManager entityManager;


	
	@SuppressWarnings("unchecked")
	public List<MainMenu> getMainMenu() {
		return entityManager.createQuery("from MainMenu").getResultList();
	}
}
