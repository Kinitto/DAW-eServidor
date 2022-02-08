package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.model.enums.ItemRank;

@Entity
@Table(name = "t_items")
public class MagicItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private ItemRank rank;
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<>();

	
	public MagicItems(Long id, String name, String description, ItemRank rank, List<Comments> comments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rank = rank;
		this.comments = comments;
	}

	public MagicItems() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemRank getRank() {
		return rank;
	}

	public void setRank(ItemRank rank) {
		this.rank = rank;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	
}
