package com.digimaster.mybackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class MovieFavoriteController {
	@Autowired
	private MovieFavoriteService movieFavoriteService;
	
	@PostMapping("/add")
	public boolean favoriteMovie(@RequestParam int userId, @RequestParam int movieId) {
		return movieFavoriteService.favoriteMovie(userId, movieId);
	}
	
	@DeleteMapping("/remove/{id}")
	public boolean unFavoriteMovie(@PathVariable int id) {
		return movieFavoriteService.unFavoriteMovie(id);
	}
	
	@GetMapping("/get/{userId}")
	public Iterable<MovieFavoriteModel> getFavoriteMovies(@PathVariable int userId){
		return movieFavoriteService.getAllFavoriteMovie(userId);
	}
}
