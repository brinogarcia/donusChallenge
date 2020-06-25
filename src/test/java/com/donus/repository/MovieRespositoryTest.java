package com.donus.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donus.entity.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRespositoryTest {

	@Autowired
	private MovieRepository movieRepository;

	@Test
	public void testMovie() {
		List<Movie> movie = movieRepository.findByNome("FilmeTeste");
		assertThat(movie.size()).isEqualTo(1);
	}

	@Test
	public void testListMovieCensurado() {
		List<Movie> movieCensurado = movieRepository.findByCensura("CENSURADO");
		assertThat(movieCensurado.size()).isEqualTo(2);
	}

	@Test
	public void testListMovieSemCensura() {
		List<Movie> movieSemCensura = movieRepository.findByCensura("SEM_CENSURA");
		assertThat(movieSemCensura.size()).isEqualTo(2);
	}

}
