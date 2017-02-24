package com.tristan3fish.gravity;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Rectangle;


@SuppressWarnings("serial")
public class GravityApplet extends Applet implements Runnable {
	private Thread _ticker;
	private int height;
	private int width;
	private boolean _isRunning;
	//private Rectangle boundary;
	private Image offscreenImage;
	private Graphics offscr;

	public void init(){
		_isRunning = false;
		Dimension d = new Dimension();
		d.setSize(1000, 600);
		setSize(d);
		width = getSize().width;
		height = getSize().height;
		//boundary = new Rectangle(width, height);
		

		
	}
	
	@Override
	public void update(Graphics g){
		if (offscr == null) {
			offscreenImage = createImage(width, height);
			offscr = offscreenImage.getGraphics();
		}

		
		
		offscr.setColor(new Color(0,0,0));
		offscr.fillRect(0, 0, width, height); 
		
		//lines
		offscr.setColor(new Color(100,100,100));
		for(int i = 0;i<width; i +=width/10){
			offscr.fillRect(i, 0, 1, width);
			offscr.fillRect(0, i, width, 1);
		}
		
		//star
		offscr.setColor(new Color(255,255,40));
		offscr.fillOval((int) (width/2)-5, (int) (height/2)-5, 10, 10);
		
		
		
		//offscr.fillRect(40, 0, 1, width);
		//offscr.fillRect(60, 0, 1, width);
		
		
		g.drawImage(offscreenImage, 0, 0, this);
	}
	
	@Override
	public void run() {
		while(_isRunning){
			repaint();
			try {
				Thread.sleep((long) (1000/getFramesPerSecond()));
			} catch (InterruptedException e) { }
		}
	}
	
	public synchronized void start () {
		if (_ticker == null || !_ticker.isAlive()) {
			_isRunning = true;
			_ticker = new Thread(this); 
			_ticker.setPriority(Thread.MIN_PRIORITY + 1); 
			_ticker.start();
		}
	}
	
	public synchronized void stop () {
		_isRunning = false;
	}
	
	public static double getFramesPerSecond(){
		return 10f;
	}
}
