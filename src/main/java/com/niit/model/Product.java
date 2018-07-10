package com.niit.model;







import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;







@Entity
@Table
public class Product {
@Id
@GeneratedValue
int prodId;
String prodName,prodDesc;
int price,stock;
int categoryId,suppId;

@Transient
 MultipartFile pimage;

public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public String getProdDesc() {
	return prodDesc;
}
public void setProdDesc(String prodDesc) {
	this.prodDesc = prodDesc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getSuppId() {
	return suppId;
}
public void setSuppId(int suppId) {
	this.suppId = suppId;
}
}
