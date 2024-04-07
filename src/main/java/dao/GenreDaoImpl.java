package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.Film;
import metier.Genre;
import util.JPAutil;

public class GenreDaoImpl implements IGenreDao {
	private EntityManager entityManager = JPAutil.getEntityManager("TP6_JEE_F");

	@Override
	public Genre save(Genre gen) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(gen);
		tx.commit();
		return gen;
	}

	@Override
	public Genre getGenre(Long id) {
		return entityManager.find(Genre.class, id);
	}

	@Override
	public Genre updateGenre(Genre gen) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(gen);
		tx.commit();
		return gen;
	}

	@Override
	public void deleteGenre(Long id) {
		Genre genre = entityManager.find(Genre.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(genre);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<Genre> getAllGenres() {
		List<Genre> gen = entityManager.createQuery("select g from Genre g").getResultList();
		return gen;
	}

}
