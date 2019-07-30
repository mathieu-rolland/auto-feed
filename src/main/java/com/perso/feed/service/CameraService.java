package com.perso.feed.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class CameraService {

	private static final int CAMERA_STREAM_PORT = 8090;
	
	private static final String CMD_START_STREAM = "/product/auto-feed/mjpg-streamer-experimental/mjpg_streamer -o \"output_http.so -w /product/auto-feed/mjpg-streamer-experimental/www -p "+CAMERA_STREAM_PORT+"\" -i \"input_raspicam.so\"";
	
	public boolean cameraIsRunning() {
		return false;
	}
	
	public void startStreaming() {
		
		try {
			Process p = Runtime.getRuntime().exec( CMD_START_STREAM );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
