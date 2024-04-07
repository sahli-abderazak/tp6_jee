package web;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import dao.GenreDaoImpl;
import dao.IGenreDao;
import metier.Genre;

@WebServlet(name = "genServ", urlPatterns = { "/genres", "/saisieGenre", "/saveGenre", "/supprimerGen", "/editerGen",
		"/updateGen" })
public class GenreServlet extends HttpServlet {
	IGenreDao metier;

	@Override
	public void init() throws ServletException {
		metier = new GenreDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/genres")) {
			GenreModele model = new GenreModele();
			List<Genre> gen = metier.getAllGenres();
			model.setGenres(gen);
			request.setAttribute("model", model);
			request.getRequestDispatcher("genres.jsp").forward(request, response);
		} else if (path.equals("/saisieGenre")) {
			request.getRequestDispatcher("saisieGenre.jsp").forward(request, response);
		} else if (path.equals("/saveGenre") &&

				request.getMethod().equals("POST"))

		{
			Date dateGen = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				dateGen = simpleDateFormat.parse(request.getParameter("dateGen"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			Genre gen = metier.save(new Genre(nom, dateGen));
			request.setAttribute("genre", gen);
			response.sendRedirect("genres");
		} else if (path.equals("/supprimerGen")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteGenre(id);
			response.sendRedirect("genres");
		} else if (path.equals("/editerGen")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Genre gen = metier.getGenre(id);
			request.setAttribute("genre", gen);
			request.getRequestDispatcher("editerGenre.jsp").forward(request, response);
		} else if (path.equals("/updateGen")) {
			Date dateGen = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			Genre gen = new Genre();
			gen.setIdGen(id);
			gen.setNomGen(nom);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {

				dateGen = simpleDateFormat.parse(request.getParameter("dateCreation"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
			gen.setDateCreation(dateGen);
			metier.updateGenre(gen);
			response.sendRedirect("genres");
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
