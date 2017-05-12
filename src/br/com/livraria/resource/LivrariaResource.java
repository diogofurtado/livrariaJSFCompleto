package br.com.livraria.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.livraria.dao.DAO;
import br.com.livraria.modelo.Autor;
import br.com.livraria.modelo.Livro;

@Path("livraria")
public class LivrariaResource {
	
	
	@Path("autores")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca() {
		List autores = new ArrayList<Autor>();
		autores = getAutores();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(autores);
		return json;
	}
	
	
	@Path("livros")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaLivros() {
		List livros = new ArrayList<Livro>();
		livros = getLivros();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(livros);
		return json;
	}
	
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

}


