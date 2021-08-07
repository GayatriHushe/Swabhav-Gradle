package com.techlabs.models;

public class Student {
	private String name;
	private int rollno;
	private double cgpa;

	public Student(String name, int rollno, double cgpa) {
		this.name = name;
		this.rollno = rollno;
		this.cgpa = cgpa;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
