package com.perso.feed.service;

import org.springframework.stereotype.Service;

import com.perso.feed.config.BoxContextSingleton;
import com.perso.feed.model.Drawer;
import com.perso.feed.model.DrawerStateEnum;

@Service
public class DrawerService {

	public Drawer openDrawer( Drawer drawer ) throws InterruptedException {
		
		BoxContextSingleton boxSingleton = BoxContextSingleton.getInstance();
		
		drawer.setState( DrawerStateEnum.OPENING );
		
		boxSingleton.getLedPin().high();
		drawer.getMotorPlus().high();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			stopInError(drawer);
			throw e;
		}
		
		boxSingleton.getLedPin().low();
		drawer.getMotorPlus().low();
		
		drawer.setState( DrawerStateEnum.OPEN );
		
		return drawer;
		
	}

	public Drawer closeDrawer( Drawer drawer ) throws InterruptedException {
		
		BoxContextSingleton boxSingleton = BoxContextSingleton.getInstance();
		
		drawer.setState( DrawerStateEnum.CLOSING );
		
		boxSingleton.getLedPin().high();
		drawer.getMotorLess().high();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			stopInError(drawer);
			throw e;
		}
		
		boxSingleton.getLedPin().low();
		drawer.getMotorLess().low();
		
		drawer.setState( DrawerStateEnum.CLOSED );
		
		return drawer;
		
	}
	
	private void stopInError( Drawer drawer ) {
		BoxContextSingleton boxSingleton = BoxContextSingleton.getInstance();
		boxSingleton.getLedPin().low();
		drawer.getMotorPlus().low();
	}
	
}
