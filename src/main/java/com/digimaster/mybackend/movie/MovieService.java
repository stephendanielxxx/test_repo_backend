package com.digimaster.mybackend.movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	private final Path root = Paths.get("/Users/teke/Documents/Backend/mybackend/images");
	
	public Iterable<MovieModel> createMovies(Iterable<MovieModel> movies){
		return movieRepository.saveAll(movies);
	}
	
	public MovieModel getMovieById(int id) {
		return movieRepository.findById(id).get();
	}

	public MovieModel getMovieModelByTitleAndGenre(String title, String genre) {
		return movieRepository.getMovieModelByTitleAndGenre(title, genre);
	}
	
	public Iterable<MovieModel> getMoviesByGenre(String genre){
		return movieRepository.getMovieModelByGenre(genre);
	}
	
	public void deleteMovieByTitle(String title) {
		movieRepository.deleteMovieModelByTitle(title);
	}
	
	public void saveFile(MultipartFile file, int id) {
		try {
			if (!Files.exists(root)) {
				Files.createDirectories(root);
			}
			
			Optional<MovieModel> currentPerson = movieRepository.findById(id);
			if(currentPerson.isPresent()) {
				currentPerson.get().setImage(file.getOriginalFilename());
				movieRepository.save(currentPerson.get());
				Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()), 
						StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<MovieModel> getAllMovies(){
		return movieRepository.findAll(Sort.by(Order.asc("title")));
	}
	
	public Page<MovieModel> getMovies(int page, int count){
		PageRequest pagination = PageRequest.of(page, count);
		return movieRepository.findAll(pagination);
	}
	
	public List<MovieModel> getMovies(String genre, int page, int count){
		Pageable pagination = PageRequest.of(page, count);
		return movieRepository.findAllByGenre(genre, pagination);
	}

	public Slice<MovieModel> getMoviesByYear(String year, int page, int count){
		Pageable pagination = PageRequest.of(page, count);
		return movieRepository.findAllByReleaseYear(year, pagination);
	}
	
	public MovieModel getMovieByTitle(String title) {
		return movieRepository.findMovieByTitle(title);
	}
	
	public List<MovieModel> getMoviesByTitle(String title){
		return movieRepository.findMoviesByTitle(title);
	}
}
