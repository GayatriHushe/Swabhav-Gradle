package com.techlabs.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	private int oid;
	private String date;
	
	@OneToMany(mappedBy="ord", cascade = CascadeType.ALL)
	private Set<Lineitem> lineitems;
	
	@ManyToOne
	@JoinColumn
	private Customer cust;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Set<Lineitem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(Set<Lineitem> lineitems) {
		this.lineitems = lineitems;
	}

	
	
	
}
