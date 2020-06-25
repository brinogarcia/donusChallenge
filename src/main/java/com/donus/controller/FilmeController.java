package com.donus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donus.entity.Movie;
import com.donus.service.MovieService;

@RestController
@RequestMapping("/movie")
public class FilmeController {
	@Autowired
	MovieService movieService;

	@PostMapping("/create")
	public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
		String create = "";
		create = movieService.createMovieService(movie);

		return ResponseEntity.ok().body(create);
	}

	@GetMapping("/list")
	public ResponseEntity<Object> listMovies(@RequestParam String nivel_censura) {
		List<Movie> listMovie = movieService.listMovieService(nivel_censura);
		return ResponseEntity.ok().body(listMovie);
	}
}
