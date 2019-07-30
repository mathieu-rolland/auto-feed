package com.perso.feed.config;

import com.perso.feed.model.Drawer;
import com.perso.feed.model.DrawerStateEnum;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import lombok.Getter;

@Getter
public class BoxContextSingleton {

	private Drawer drawer1;
	private Drawer drawer2;
	
	private GpioPinDigitalOutput ledPin;
	
	private static BoxContextSingleton singleton;
	
	public static BoxContextSingleton getInstance() {
		if( singleton == null ) {
			singleton = new BoxContextSingleton();
			singleton.initContext();
		}
		return singleton;
	}
	
	public void initContext() {
		
		final GpioController gpio = GpioFactory.getInstance();
		
		ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);
		ledPin.setShutdownOptions(true, PinState.LOW);
		
		GpioPinDigitalOutput motor1Pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "motor1Pin1", PinState.LOW);
		motor1Pin1.setShutdownOptions(true, PinState.LOW);
		
		GpioPinDigitalOutput motor1Pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "motor1Pin2", PinState.LOW);
		motor1Pin2.setShutdownOptions(true, PinState.LOW);
		
		drawer1 = new Drawer( "motor1Pin1" , DrawerStateEnum.CLOSED, motor1Pin1, motor1Pin2);
		
	}
	
}
