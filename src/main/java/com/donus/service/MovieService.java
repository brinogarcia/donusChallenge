package com.donus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.donus.entity.Movie;
import com.donus.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;

	public String createMovieService(Movie movie) {
		if (movieRepository.findByNome(movie.getNome()).size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe um filme com este nome " + movie.getNome() + " !", null);
		}
		if (movie.getAtores().size() > 10) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de atores maior que 10 !", null);
		}

		movieRepository.saveAndFlush(movie);
		return "Filme criado com sucesso!";
	}

	public List<Movie> listMovieService(String nivel_censura) {

		if (!(nivel_censura.equals("CENSURADO") || nivel_censura.equals("SEM_CENSURA"))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um valor correto para nivel de censura",
					null);
		}

		List<Movie> listMovies = movieRepository.findByCensura(nivel_censura);
		return listMovies;

	}

}
