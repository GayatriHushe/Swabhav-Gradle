package com.techlabs.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private int pid;
	private String pname;
	private int pcost;
	
	@ManyToOne
	@JoinColumn
	private Lineitem item;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public Lineitem getItem() {
		return item;
	}

	public void setItem(Lineitem item) {
		this.item = item;
	}
	
	
	
}
