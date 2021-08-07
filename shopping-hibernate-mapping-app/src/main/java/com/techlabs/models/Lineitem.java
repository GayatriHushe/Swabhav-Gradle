package com.techlabs.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lineitem {
	
	@Id
	private int lid;
	private int qty;
	
	@OneToMany(mappedBy="item", cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@ManyToOne
	@JoinColumn
	private Orders ord;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Orders getOrd() {
		return ord;
	}

	public void setOrd(Orders ord) {
		this.ord = ord;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
