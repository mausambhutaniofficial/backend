package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
@Id
@GeneratedValue
int suppId;
String suppName,suppAddr;
public int getSuppId() {
	return suppId;
}
public void setSuppId(int suppId) {
	this.suppId = suppId;
}
public String getSupName() {
	return suppName;
}
public void setSupName(String supName) {
	this.suppName = supName;
}
public String getSupAddr() {
	return suppAddr;
}
public void setSupAddr(String supAddr) {
	this.suppAddr = supAddr;
}






}
