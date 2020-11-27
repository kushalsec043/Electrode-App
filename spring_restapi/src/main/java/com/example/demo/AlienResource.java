package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource
{
	
@RequestMapping("aliens")
public List<Alien> getaliens()
{
	List<Alien> aliens = new ArrayList<>();
	
	Alien a1 = new Alien();
	
	a1.setName("hhh");
	a1.setPoints(200);
	
	aliens.add(a1);
	
	return aliens;
}
}
