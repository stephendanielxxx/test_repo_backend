package com.digimaster.mybackend.user;

import org.springframework.data.repository.CrudRepository;

public interface MovieFavoriteRepository extends CrudRepository<MovieFavoriteModel, Integer>{
	Iterable<MovieFavoriteModel> getMovieFavoriteModelByUserId(int userId);
}
