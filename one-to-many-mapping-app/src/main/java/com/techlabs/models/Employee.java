package com.techlabs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class Employee {
  @Id
  private String ename;
  @ManyToOne
  @JoinColumn
  private Department dept;
  
  public Employee(String ename) {
    this.ename=ename;
  }

  public String getEname() {
    return ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public Department getDept() {
    return dept;
  }

  public void setDept(Department dept) {
    this.dept = dept;
  }

}