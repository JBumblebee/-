package com.model;
//书的实体类
public class Good { 
 private String id;
 private String name;
 private String author;
 private double price;
 private String description;
 private String type;
 private String img;



public Good() {
 super();
 }
 public Good(String id, String name, String author, double price,
  String description ,String type ,String img) {
 super();
 this.id = id;
 this.name = name;
 this.author = author;
 this.price = price;
 this.description = description;
 this.type = type;
 this.img = img;
 }
 public String getId() {
 return id;
 }
 public void setId(String id) {
 this.id = id;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public String getAuthor() {
 return author;
 }
 public void setAuthor(String author) {
 this.author = author;
 }
 public double getPrice() {
 return price;
 }
 public void setPrice(double price) {
 this.price = price;
 }
 public String getDescription() {
 return description;
 }
 public void setDescription(String description) {
 this.description = description;
 }
 public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
 
 
}