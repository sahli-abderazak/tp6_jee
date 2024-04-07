package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.JPAutil;
import metier.Film;


public class filmDaoImpl implements lFilmDao {
	private EntityManager entityManager=JPAutil.getEntityManager("TP6_JEE_F");
	
	
	@Override
	public Film save(Film f) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(f);
		tx.commit();
		return f;
	}

	@Override
	public List<Film> filmsParMC(String mc) {
		List<Film> films=entityManager.createQuery("select f from Film f where f.nomFilm like :mc").setParameter("mc", "%"+mc+"%").getResultList();
			return films;
	}

	@Override
	public Film getFilm(Long id) {  
		return entityManager.find(Film.class, id);
			
	}

	@Override
	public Film updateFilm(Film f) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(f);
		tx.commit();
		return f;
	}

	@Override
	public void deleteFilm(Long id) {
		Film film = entityManager.find(Film.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(film);
		entityManager.getTransaction().commit();
	}



}