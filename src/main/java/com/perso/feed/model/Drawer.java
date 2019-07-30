package com.perso.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drawer {

	private String name;
	private DrawerStateEnum state;
	
	@JsonIgnore
	private transient GpioPinDigitalOutput motorPlus;
	@JsonIgnore
	private transient GpioPinDigitalOutput motorLess;
	
	
	public String toString() {
		return "Name : " + name + ", state : " + state.getName();
	}
	
}
