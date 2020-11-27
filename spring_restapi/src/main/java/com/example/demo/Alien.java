package com.example.demo;

import javax.persistence.Entity;

@Entity
public class Alien
{
int id; 
String name;
int points;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}


}
