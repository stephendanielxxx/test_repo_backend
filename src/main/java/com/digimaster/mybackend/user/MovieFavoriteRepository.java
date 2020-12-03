package com.digimaster.mybackend.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.digimaster.mybackend.movie.MovieModel;

public interface MovieFavoriteRepository extends CrudRepository<MovieFavoriteModel, Integer>{
	Iterable<MovieFavoriteModel> getMovieFavoriteModelByUserId(int userId);
}
