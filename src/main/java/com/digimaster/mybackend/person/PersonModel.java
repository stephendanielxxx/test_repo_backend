package com.digimaster.mybackend.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.digimaster.mybackend.address.AddressModel;

import lombok.Data;
@Entity
@Table(name = "tb_person")
@Data
public class PersonModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "city")
	private String city;
	@Column(name = "profile")
	private String profile;
	@OneToOne
	@JoinColumn(name = "adress_id")
	private AddressModel addressModel;
	
}
