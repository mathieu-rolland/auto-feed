package com.perso.feed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perso.feed.config.BoxContextSingleton;
import com.perso.feed.model.Drawer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoxService {

	private BoxContextSingleton boxSingleton = BoxContextSingleton.getInstance();
	
	@Autowired
	private DrawerService drawerService;
	
	public Drawer openDrawer( int number ) throws InterruptedException {
		if( number == 1 ) {
			return drawerService.openDrawer( boxSingleton.getDrawer1() );
		}else {
			log.warn("The drawer number 2 is not implemented yet.");
			return null;
		}
			
	}
	
	public Drawer closeDrawer( int number ) throws InterruptedException {
		if( number == 1 ) {
			return drawerService.closeDrawer( boxSingleton.getDrawer1() );
		}else {
			log.warn("The drawer number 2 is not implemented yet.");
			return null;
		}
			
	}
	
}
