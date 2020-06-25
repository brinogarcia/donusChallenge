package com.donus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donus.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long >{

	List<Movie> findByCensura(String censura);
	List<Movie> findByNome(String nome);
	
}
