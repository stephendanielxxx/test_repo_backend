package com.digimaster.mybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/")
	public Iterable<MovieModel> createMovies(@RequestBody Iterable<MovieModel> movieModels){
		return movieService.createMovies(movieModels);
	}
	
	@GetMapping("/{id}")
	public MovieModel getMovieById(@PathVariable int id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/get")
	public MovieModel getMovieByTitleAndGenre(@RequestParam String title, @RequestParam String genre) {
		return movieService.getMovieModelByTitleAndGenre(title, genre);
	}
	
	@GetMapping("/get/{genre}")
	public Iterable<MovieModel> getMoviesByGenre(@PathVariable String genre){
		return movieService.getMoviesByGenre(genre);
	}
	
	@DeleteMapping("/{title}")
	public boolean deleteMovieByTitle(@PathVariable String title) {
		movieService.deleteMovieByTitle(title);
		return true;
	}
}
