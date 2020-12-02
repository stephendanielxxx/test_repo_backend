package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieFavoriteService {

	@Autowired
	private MovieFavoriteRepository movieFavoriteRepository;
	
	public boolean favoriteMovie(int userId, int movieId) {
		MovieFavoriteModel movieFavoriteModel = new MovieFavoriteModel();
		movieFavoriteModel.setUserId(userId);
		movieFavoriteModel.setMovieId(movieId);
		movieFavoriteRepository.save(movieFavoriteModel);
		return true;
	}
	
	public boolean unFavoriteMovie(int id) {
		movieFavoriteRepository.deleteById(id);
		return true;
	}
	
	public Iterable<MovieFavoriteModel> getAllFavoriteMovie(int userId){
		return movieFavoriteRepository.getMovieFavoriteModelByUserId(userId);
	}
}
