package com.digimaster.mybackend.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_movie_favorite")
@Data
public class MovieFavoriteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "movie_id")
	private int movieId;
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private UserModel userModel;

	
}
