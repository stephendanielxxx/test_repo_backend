package com.digimaster.mybackend.movie;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieModel, Integer>{

	MovieModel getMovieModelByTitleAndGenre(String title, String genre);
	
	Iterable<MovieModel> getMovieModelByGenre(String genre);

	@Transactional
	void deleteMovieModelByTitle(String title);
}
