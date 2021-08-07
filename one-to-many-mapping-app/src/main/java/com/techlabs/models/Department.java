package com.techlabs.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class Department {
  @Id
  private int deptno;
  private String dname;
  private String location;
  
  @OneToMany(mappedBy="dept", cascade = CascadeType.ALL)
  private Set<Employee> emps;
  
  public Department(int deptno,String dname,String location) {
    this.deptno=deptno;
    this.dname=dname;
    this.location=location;
  }
  public Department() {
    
  }
  public int getDeptno() {
    return deptno;
  }
  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }
  public String getDname() {
    return dname;
  }
  public void setDname(String dname) {
    this.dname = dname;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public Set<Employee> getEmps() {
    return emps;
  }
  public void setEmps(Set<Employee> emps) {
    this.emps = emps;
  }
}