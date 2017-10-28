package com.sd.uni.biblioteca.domain.autor;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.libro.LibroDomain;
@Entity
@Table(name = "autor")
public class AutorDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	
}
