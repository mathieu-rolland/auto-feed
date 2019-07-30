package com.perso.feed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DrawerStateEnum {

	OPEN("open"), 
	OPENING("OPENING") ,
	CLOSED("closed"),
	CLOSING("CLOSING");
	
	private String name;
	
	
}
