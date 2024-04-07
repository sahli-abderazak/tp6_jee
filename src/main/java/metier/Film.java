package metier;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FILMS")
public class Film implements Serializable {
	@Id
	@Column(name = "ID_FILMS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;

	@Column(name = "NOM_FILMS")
	private String nomFilm;

	@Column(name = "RATE_FILMS")
	private float rateFilm;

	@Column(name = "DATE_SORTIE")
	private LocalDate dateSortie;
	
	@ManyToOne
	@JoinColumn(name = "genre")
	
	private Genre genre;
	
	public Film(String nomFilm, float rateFilm, LocalDate dateSortie, Genre gen) {
		super();
		this.nomFilm = nomFilm;
		this.rateFilm = rateFilm;
		this.dateSortie = dateSortie;
		this.setGenre(gen);

	}

	public Film() {
		super();
	}

	public Film(String nomFilm, float rateFilm, LocalDate dateSortie) {
		super();
		this.nomFilm = nomFilm;
		this.rateFilm = rateFilm;
		this.dateSortie = dateSortie;

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public float getRateFilm() {
		return rateFilm;
	}

	public void setRateFilm(float rateFilm) {
		this.rateFilm = rateFilm;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", rateFilm=" + rateFilm + ", dateSortie="
				+ dateSortie + "]";
	}

}