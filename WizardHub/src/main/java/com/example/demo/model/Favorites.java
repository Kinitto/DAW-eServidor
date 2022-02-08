package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_favorites")
public class Favorites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_item", foreignKey = @ForeignKey(name = "FK_ITEM_ID_ITEM"))
	private MagicItems item;
	
	@ManyToOne
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_USER_ID_USER"))
	private User user;
	
	private boolean favorite;

	
	
	public Favorites(Long id, MagicItems item, User user, boolean favorite) {
		super();
		this.id = id;
		this.item = item;
		this.user = user;
		this.favorite = favorite;
	}

	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MagicItems getItem() {
		return item;
	}

	public void setItem(MagicItems item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
	
}
