package com.digimaster.mybackend.movie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Integer>{

	MovieModel getMovieModelByTitleAndGenre(String title, String genre);
	
	Iterable<MovieModel> getMovieModelByGenre(String genre);

	@Transactional
	void deleteMovieModelByTitle(String title);
	
	List<MovieModel> findAllByGenre(String name, Pageable pageable);
	
	Slice<MovieModel> findAllByReleaseYear(String year, Pageable pageable);
}
