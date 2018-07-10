package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Supplier {
@Id
@GeneratedValue
int suppId;
String suppName,suppAddr;

@Transient
MultipartFile simage;
public MultipartFile getSimage() {
	return simage;
}
public void setSimage(MultipartFile simage) {
	this.simage = simage;
}
public String getSuppName() {
	return suppName;
}
public void setSuppName(String suppName) {
	this.suppName = suppName;
}
public String getSuppAddr() {
	return suppAddr;
}
public void setSuppAddr(String suppAddr) {
	this.suppAddr = suppAddr;
}

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
