package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.enums.HogwartsHouses;
@Entity
@Table(name = "t_characters")
public class Characters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private HogwartsHouses house;
	
	

	public Characters(Long id, String name, Integer age, HogwartsHouses house) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.house = house;
	}

	public Characters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public HogwartsHouses getHouse() {
		return house;
	}

	public void setHouse(HogwartsHouses house) {
		this.house = house;
	}
	
	
}


