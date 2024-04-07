package web;

import java.util.ArrayList;
import java.util.List;

import metier.Film;

public class FilmModele {
	private String motCle;
	List<Film> films = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	

}
