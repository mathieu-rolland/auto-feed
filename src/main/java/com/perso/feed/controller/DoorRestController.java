package com.perso.feed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/door")
@Slf4j
public class DoorRestController {

	@RequestMapping("/open")
	public String openDoor() {
		log.info( "Open the door" );
		return "OPEN";
	}

	@RequestMapping("/close")
	public String closeDoor() {
		log.info( "Close the door" );
		return "CLOSE";
	}
	
	
	@RequestMapping("/test")
	public String testDoor() {
		log.info( "Start the PI test..." );
		
		final GpioController gpio = GpioFactory.getInstance();
		
		
		GpioPinDigitalOutput ledPin = (GpioPinDigitalOutput) gpio.getProvisionedPin("MyLED");
		GpioPinDigitalOutput motor1Pin1 = (GpioPinDigitalOutput) gpio.getProvisionedPin("motor1Pin1");
		GpioPinDigitalOutput motor1Pin2 = (GpioPinDigitalOutput) gpio.getProvisionedPin("motor1Pin2");
		
		
		if( ledPin == null ) {
			ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);
			ledPin.setShutdownOptions(true, PinState.LOW);
		}
		
		if( motor1Pin1 == null ) {
			motor1Pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "motor1Pin1", PinState.LOW);
			motor1Pin1.setShutdownOptions(true, PinState.LOW);
		}
		
		if( motor1Pin2 == null ) {
			motor1Pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "motor1Pin2", PinState.LOW);
			motor1Pin2.setShutdownOptions(true, PinState.LOW);
		}
		
		ledPin.high();
		motor1Pin1.high();
		log.info("--> GPIO state should be: ON ( " + ledPin.isHigh() + " )");

		
		
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        ledPin.low();
        motor1Pin1.low();
        log.info("--> GPIO state should be: OFF");
        
        //gpio.shutdown();
		
        
        log.info("End test successfully");
        
		return "Test Done!!";
	}
	
	
}
