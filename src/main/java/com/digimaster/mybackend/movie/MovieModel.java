package com.digimaster.mybackend.movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_movie")
public class MovieModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Auto increment ID")
	private int id;
	@Column(name = "title")
	@NotNull
	@ApiModelProperty(notes = "Movie title, String, Not Null")
	private String title;
	@Column(name = "genre")
	@NotNull
	@ApiModelProperty(notes = "Movie genre, String, Not Null")
	private String genre;
	@Column(name = "release_year")
	@NotNull
	@ApiModelProperty(notes = "Movie release year, String, Not Null")
	private String releaseYear;
	@Column
	@ApiModelProperty(notes = "Movie image, String, only name")
	private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
