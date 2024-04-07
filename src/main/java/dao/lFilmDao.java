package dao;

import java.util.List;

import metier.Film;

public interface lFilmDao {
public Film save(Film f);
public List<Film> filmsParMC(String mc);
public Film getFilm(Long id);
public Film updateFilm(Film p);
public void deleteFilm(Long id);
}
